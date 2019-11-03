package com.thm.photoviewer.photoview;

import com.thm.common.ModuloArray;
import com.thm.photoviewer.BaseController;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.models.Zooming;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ListChangeListener;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PhotoViewController extends BaseController<PhotoViewer> {
    private static final double TRANSITION_DURATION = 0.2;
    private static final int GAP = 10;
    private static final double TRANSITION_THRESHOLD = 100.0;

    private PhotoList photoList;
    private Zooming zooming;

    private ModuloArray<PhotoCell> photoCells;
    private double[] xSnapshots;
    private int centerIndex = 0;

    private double mouseX;
    private double mouseY;
    private boolean inTransitionMode = false;
    private boolean startDragging = false;

    public PhotoViewController(PhotoViewer view) {
        super(view);

        photoList = PhotoList.getPhotoList();

        photoCells = view.getPhotoCells();
        photoCells.forEach(photoCell -> configurePhotoCell(photoCell));
        xSnapshots = new double[photoCells.size()];

        clipChildren(view, 12);
        configureXPositionResizingUpdates();

        photoList.selectedPhotoProperty().addListener((observable, oldValue, newValue) -> onSelectedPhoto(newValue));
        photoList.addListener((ListChangeListener<? super Photo>) c -> photoListChanged());

        view.getLeftButton().setOnMouseClicked(e -> photoList.setSelectedPhoto(photoList.getNextPhoto(Direction.LEFT)));
        view.getRightButton().setOnMouseClicked(e -> photoList.setSelectedPhoto(photoList.getNextPhoto(Direction.RIGHT)));

        zooming = Zooming.getInstance();
        zooming.zoomValueProperty().addListener((observableValue, oldValue, newValue) -> zoomChanged(newValue.doubleValue()));
    }

    private void zoomChanged(double zoom) {
        if(zoom == 1.00) {
            for(var pc : photoCells) {
                var iv = pc.getImageView();
                iv.setViewport(null);
            }
            return;
        }

        var photoCell = photoCells.get(centerIndex);
        var imageView = photoCell.getImageView();
        var image = imageView.getImage();

        var width = image.getWidth() / zoom;
        var height = image.getHeight() / zoom;

        double centerX;
        double centerY;
        if(imageView.getViewport() == null) {
            centerX = image.getWidth() / 2;
            centerY = image.getHeight() / 2;
        }
        else {
            var oldRectangle = imageView.getViewport();
            centerX = oldRectangle.getMinX() + oldRectangle.getWidth() / 2;
            centerY = oldRectangle.getMinY() + oldRectangle.getHeight() / 2;
        }

        var x = clamp(centerX - width / 2, 0, image.getWidth() - width);
        var y = clamp(centerY - height / 2, 0, image.getHeight() - height);

        var rectangle = new Rectangle2D(x, y, width, height);
        imageView.setViewport(rectangle);
    }

    private void onSelectedPhoto(Photo p) {
        zooming.setZoomValue(1);

        if(p == null) {
            photoCells.stream().forEach(imageView -> imageView.setPhoto(new Photo(null, null)));
            return;
        }

        if(p.getImage().equals(photoCells.get(centerIndex).getImage())) {
            return;
        }

        var center = photoCells.get(centerIndex);
        var left = photoCells.getLeft(centerIndex);
        var right = photoCells.getRight(centerIndex);

        left.setTranslateX(calculateLeftXPosition());
        right.setTranslateX(calculateRightXPosition());

        center.setPhoto(p);
        left.setPhoto(photoList.getNextPhoto(Direction.LEFT));
        right.setPhoto(photoList.getNextPhoto(Direction.RIGHT));
    }

    private void photoListChanged() {
        if(photoList.size() == 0) {
            return;
        }

        var centerPhoto = photoCells.get(centerIndex).getPhoto();
        if(centerPhoto == null) {
            return;
        }

        var controller = new PhotoCell[] {
                photoCells.getLeft(centerIndex),
                photoCells.getRight(centerIndex)
        };

        var newPhotos = new Photo[] {
                photoList.getNextPhoto(Direction.LEFT),
                photoList.getNextPhoto(Direction.RIGHT)
        };

        for(int i = 0; i < controller.length; i++) {
            var newPhoto = newPhotos[i];
            var oldPhoto = controller[i].getPhoto();
            if(oldPhoto.equals(newPhoto) == false) {
                controller[i].setPhoto(newPhoto);
            }
        }
    }

    private void configurePhotoCell(Pane photoPane) {
        photoPane.setCursor(Cursor.HAND);

        photoPane.addEventFilter(MouseEvent.MOUSE_PRESSED, t -> {
            if(inTransitionMode) {
                startDragging = false;
                return;
            }

            mouseX = t.getSceneX();
            mouseY = t.getSceneY();

            if(zooming.zoomed() == false) {
                transitionStarted();
            }
        });

        photoPane.setOnMouseDragged(t -> {
            double offsetX = t.getSceneX() - mouseX;
            mouseX = t.getSceneX();

            double offsetY = t.getSceneY() - mouseY;
            mouseY = t.getSceneY();

            if(zooming.zoomed() == false) {
                transitionDraggedMouse(offsetX);
            }
            else {
                zoomMove(offsetX, offsetY);
            }
        });

        photoPane.addEventFilter(MouseEvent.MOUSE_RELEASED, t -> {
            if(zooming.zoomed() == false) {
                transitionMouseReleased();
            }
        });
    }

    private void zoomMove(double offsetX, double offsetY) {
        var imageView = photoCells.get(centerIndex).getImageView();
        var image = imageView.getImage();
        var rectangle = imageView.getViewport();

        double newX = clamp(rectangle.getMinX() - offsetX, 0, image.getWidth() - rectangle.getWidth());
        double newY = clamp(rectangle.getMinY() - offsetY, 0, image.getHeight() - rectangle.getHeight());

        var newRectangle = new Rectangle2D(newX, newY, rectangle.getWidth(), rectangle.getHeight());
        imageView.setViewport(newRectangle);
    }

    public static double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    private void transitionStarted() {
        startDragging = true;
        snapshottingXPosition();
    }

    private void transitionDraggedMouse(double offsetX) {
        if(startDragging == false) {
            return;
        }


        var left = photoCells.getLeft(centerIndex);
        var right = photoCells.getRight(centerIndex);
        if((left.getTranslateX() > -10 && offsetX > 0)
                || (right.getTranslateX() < 10 && offsetX < 0)) {
            return;
        }

        moveXPositions(offsetX);
    }

    private void transitionMouseReleased() {
        if(startDragging == false) {
            return;
        }

        var center = photoCells.get(centerIndex);
        var centerPosition = center.getTranslateX();

        var right = photoCells.getRight(centerIndex);
        var left = photoCells.getLeft(centerIndex);
        if(centerPosition > TRANSITION_THRESHOLD) {
            right.setTranslateX(left.getTranslateX() + calculateLeftXPosition());
            // new centerIndex is the old left index
            leftTransition();
            photoList.setSelectedPhoto(photoList.getNextPhoto(Direction.LEFT));

            // the old left image is now the center image, so a new left image must be loaded
            var leftController = photoCells.getLeft(centerIndex);
            leftController.setPhoto(photoList.getNextPhoto(Direction.LEFT));
        }
        else if(centerPosition < -TRANSITION_THRESHOLD) {
            left.setTranslateX(right.getTranslateX() + calculateRightXPosition());
            // new centerIndex is the old right index
            rightTransition();
            photoList.setSelectedPhoto(photoList.getNextPhoto(Direction.RIGHT));

            // the old right image is now the center image, so a new right image must be loaded
            var rightController = photoCells.getRight(centerIndex);
            rightController.setPhoto(photoList.getNextPhoto(Direction.RIGHT));
        }
        else {
            centerTransition();
        }
    }

    private void snapshottingXPosition() {
        for(int i = 0; i < xSnapshots.length; i++) {
            xSnapshots[i] = photoCells.get(i).getTranslateX();
        }
    }

    private void moveXPositions(double offset) {
        for(int i = 0; i < xSnapshots.length; i++) {
            double newX = xSnapshots[i] + offset;
            photoCells.get(i).setTranslateX(newX);

            xSnapshots[i] = newX;
        }
    }

    private double calculateLeftXPosition() {
        return - view.getWidth() - GAP;
    }

    private double calculateRightXPosition() {
        return view.getWidth() + GAP;
    }

    private void centerTransition() {
        var center = photoCells.get(centerIndex);
        var offset = center.getTranslateX();

        var centerTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), center);
        centerTransition.setFromX(offset);
        centerTransition.setToX(0);

        var left = photoCells.getLeft(centerIndex);
        var leftTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), left);
        leftTransition.setFromX(left.getTranslateX());
        leftTransition.setToX(left.getTranslateX() - offset);

        var right = photoCells.getRight(centerIndex);
        var rightTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), right);
        rightTransition.setFromX(right.getTranslateX());
        rightTransition.setToX(right.getTranslateX() - offset);

        var parallelTransition = new ParallelTransition(centerTransition, leftTransition, rightTransition);
        parallelTransition.setOnFinished(event -> inTransitionMode = false);

        inTransitionMode = true;
        parallelTransition.play();
    }

    private void leftTransition() {
        var left = photoCells.getLeft(centerIndex);
        centerIndex = photoCells.indexOf(left);
        centerTransition();
    }

    private void rightTransition() {
        var right = photoCells.getRight(centerIndex);
        centerIndex = photoCells.indexOf(right);
        centerTransition();
    }

    private void configureXPositionResizingUpdates() {
        view.widthProperty().addListener((observable, oldValue, newValue) -> {
            var left = photoCells.getLeft(centerIndex);
            left.setTranslateX(calculateLeftXPosition());

            var right = photoCells.getRight(centerIndex);
            right.setTranslateX(calculateRightXPosition());
        });
    }

    private void clipChildren(Region region, double arc) {
        final Rectangle outputClip = new Rectangle();
        outputClip.setArcWidth(arc);
        outputClip.setArcHeight(arc);
        region.setClip(outputClip);

        region.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }
}
