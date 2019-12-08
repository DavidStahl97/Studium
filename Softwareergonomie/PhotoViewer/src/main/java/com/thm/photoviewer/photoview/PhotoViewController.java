package com.thm.photoviewer.photoview;

import com.thm.common.MathUtil;
import com.thm.common.ModuloArray;
import com.thm.photoviewer.BaseController;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.models.Zooming;
import com.thm.photoviewer.photoview.states.MouseEventState;
import com.thm.photoviewer.photoview.states.SlideMouseEventState;
import com.thm.photoviewer.photoview.states.ZoomedMouseEventState;
import javafx.collections.ListChangeListener;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

public class PhotoViewController extends BaseController<PhotoViewer> {
    private static final int GAP = 10;

    private PhotoList photoList;
    private Zooming zooming;

    private ModuloArray<PhotoCell> photoCells;

    private double mouseX;
    private double mouseY;

    private MouseEventState mouseEventState;

    public PhotoViewController(PhotoViewer view, PhotoList photoList, Zooming zooming) {
        super(view);
        this.photoList = photoList;
        this.zooming = zooming;

        photoCells = view.getPhotoCells();
        photoCells.forEach(photoCell -> configureMouseEvents(photoCell));

        clipChildren(view, 12);
        configureXPositionResizingUpdates();

        photoList.selectedPhotoProperty().addListener((observable, oldValue, newValue) -> onSelectedPhoto(newValue));
        photoList.addListener((ListChangeListener<? super Photo>) c -> photoListChanged());

        view.getLeftButton().setOnMouseClicked(e -> photoList.setSelectedPhoto(photoList.getNextPhoto(Direction.LEFT)));
        view.getRightButton().setOnMouseClicked(e -> photoList.setSelectedPhoto(photoList.getNextPhoto(Direction.RIGHT)));

        zooming.zoomValueProperty().addListener((observableValue, oldValue, newValue) -> zoomChanged(newValue.doubleValue()));

        mouseEventState = new SlideMouseEventState(photoCells, view, photoList);
    }

    private void zoomChanged(double zoom) {
        mouseEventState = zoom == 1.00 ?
                new SlideMouseEventState(photoCells, view, photoList) :
                new ZoomedMouseEventState(photoCells, view);

        if(zoom == 1.00) {
            for(var pc : photoCells) {
                var iv = pc.getImageView();
                iv.setViewport(null);
            }
            return;
        }

        var photoCell = photoCells.getCenter();
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

        var x = MathUtil.clamp(centerX - width / 2, 0, image.getWidth() - width);
        var y = MathUtil.clamp(centerY - height / 2, 0, image.getHeight() - height);

        var rectangle = new Rectangle2D(x, y, width, height);
        imageView.setViewport(rectangle);
    }

    private void onSelectedPhoto(Photo p) {
        zooming.setZoomValue(1);

        if(p == null) {
            photoCells.stream().forEach(imageView -> imageView.setImage(null));
            return;
        }

        if(p.getImage().equals(photoCells.getCenter().getImage())) {
            return;
        }

        var center = photoCells.getCenter();
        var left = photoCells.getLeft();
        var right = photoCells.getRight();

        left.setTranslateX(calculateLeftXPosition(view));
        right.setTranslateX(calculateRightXPosition(view));

        center.setImage(p.getImage());
        left.setImage(photoList.getNextPhoto(Direction.LEFT).getImage());
        right.setImage(photoList.getNextPhoto(Direction.RIGHT).getImage());
    }

    private void photoListChanged() {
        if(photoList.size() == 0) {
            return;
        }

        var centerImage = photoCells.getCenter().getImage();
        if(centerImage == null) {
            return;
        }

        var controller = new PhotoCell[] {
                photoCells.getLeft(),
                photoCells.getRight()
        };

        var newPhotos = new Photo[] {
                photoList.getNextPhoto(Direction.LEFT),
                photoList.getNextPhoto(Direction.RIGHT)
        };

        for(int i = 0; i < controller.length; i++) {
            var newPhotoCell = newPhotos[i];
            var oldImage = controller[i].getImage();
            if(oldImage.equals(newPhotoCell.getImage()) == false) {
                controller[i].setImage(newPhotoCell.getImage());
            }
        }
    }

    private void configureMouseEvents(Pane photoPane) {
        photoPane.setCursor(Cursor.HAND);

        photoPane.addEventFilter(MouseEvent.MOUSE_PRESSED, t -> {
            mouseX = t.getSceneX();
            mouseY = t.getSceneY();

            mouseEventState.OnMousePressed();
        });

        photoPane.setOnMouseDragged(t -> {
            double offsetX = t.getSceneX() - mouseX;
            mouseX = t.getSceneX();

            double offsetY = t.getSceneY() - mouseY;
            mouseY = t.getSceneY();

            mouseEventState.OnMouseDragged(offsetX, offsetY);
        });

        photoPane.addEventFilter(MouseEvent.MOUSE_RELEASED, t -> {
            mouseEventState.OnMouseReleased();
        });
    }

    public static double calculateLeftXPosition(PhotoViewer view) {
        return - view.getWidth() - GAP;
    }

    public static double calculateRightXPosition(PhotoViewer view) {
        return view.getWidth() + GAP;
    }

    private void configureXPositionResizingUpdates() {
        view.widthProperty().addListener((observable, oldValue, newValue) -> {
            var left = photoCells.getLeft();
            left.setTranslateX(calculateLeftXPosition(view));

            var right = photoCells.getRight();
            right.setTranslateX(calculateRightXPosition(view));
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