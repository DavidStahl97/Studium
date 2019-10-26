package com.thm.photoviewer.controller;

import com.thm.ModuloArray;
import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.views.ShowPhotosView;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ShowPhotosController extends ControllerBase<ShowPhotosView> {
    private static final double TRANSITION_DURATION = 0.4;
    private static final int GAP = 10;
    private static final double TRANSITION_THRESHOLD = 100.0;
    private static final int PHOTO_VIEW_COUNT = 3;

    private PhotoList photoList;

    private ModuloArray<PhotoViewController> photoViewControllers;
    private double[] xSnapshots;
    private int centerIndex = 0;

    private double orgSceneX;
    private boolean inTransitionMode = false;
    private boolean startDragging = false;

    public ShowPhotosController(PhotoList photoList) {
        super(ShowPhotosView.class);

        photoViewControllers = new ModuloArray<>();
        createPhotoViews();

        xSnapshots = new double[photoViewControllers.size()];

        clipChildren(view, 12);
        configureXPositionResizingUpdates();

        this.photoList = photoList;
        photoList.selectedPhotoProperty().addListener((observable, oldValue, newValue) -> onSelectedPhoto(newValue));
    }

    private void createPhotoViews() {
        for(int i = 0; i < PHOTO_VIEW_COUNT; i++) {
            var photoViewController = new PhotoViewController();
            var photoView = photoViewController.getParentPane();
            configurePhotoView(photoView);
            this.photoViewControllers.add(photoViewController);

            view.getChildren().add(photoView);
            photoView.prefWidthProperty().bind(view.widthProperty());
            photoView.prefHeightProperty().bind(view.heightProperty());
        }
    }

    private void configureXPositionResizingUpdates() {
        view.widthProperty().addListener((observable, oldValue, newValue) -> {
            var left = photoViewControllers.getLeft(centerIndex).getParentPane();
            left.setTranslateX(calculateLeftXPosition());

            var right = photoViewControllers.getRight(centerIndex).getParentPane();
            right.setTranslateX(calculateRightXPosition());
        });
    }

    private void onSelectedPhoto(Photo p) {
        if(p == null) {
            photoViewControllers.stream().forEach(imageView -> imageView.setImage(null));
            return;
        }

        if(p.getImage().equals(photoViewControllers.get(centerIndex).getImage())) {
            return;
        }

        var centerController = photoViewControllers.get(centerIndex);
        var leftController = photoViewControllers.getLeft(centerIndex);
        var rightController = photoViewControllers.getRight(centerIndex);

        leftController.getParentPane().setTranslateX(calculateLeftXPosition());
        rightController.getParentPane().setTranslateX(calculateRightXPosition());

        centerController.setImage(p.getImage());
        leftController.setImage(photoList.getNextPhoto(Direction.LEFT).getImage());
        rightController.setImage(photoList.getNextPhoto(Direction.RIGHT).getImage());
    }

    private void configurePhotoView(Pane photoPane) {
        photoPane.setCursor(Cursor.HAND);

        photoPane.addEventFilter(MouseEvent.MOUSE_PRESSED, t -> {
            if(inTransitionMode) {
                startDragging = false;
                return;
            }

            startDragging = true;

            orgSceneX = t.getSceneX();
            snapshottingXPosition();
        });

        photoPane.setOnMouseDragged(t -> {
            if(startDragging == false) {
                return;
            }

            double offsetX = t.getSceneX() - orgSceneX;
            orgSceneX = t.getSceneX();

            var left = photoViewControllers.getLeft(centerIndex).getParentPane();
            var right = photoViewControllers.getRight(centerIndex).getParentPane();
            if((left.getTranslateX() > -10 && offsetX > 0)
                    || (right.getTranslateX() < 10 && offsetX < 0)) {
                return;
            }

            moveXPositions(offsetX);
        });

        photoPane.addEventFilter(MouseEvent.MOUSE_RELEASED, t -> {
            if(startDragging == false) {
                return;
            }

            var center = photoViewControllers.get(centerIndex).getParentPane();
            var centerPosition = center.getTranslateX();

            var right = photoViewControllers.getRight(centerIndex).getParentPane();
            var left = photoViewControllers.getLeft(centerIndex).getParentPane();
            if(centerPosition > TRANSITION_THRESHOLD) {
                right.setTranslateX(left.getTranslateX() + calculateLeftXPosition());
                leftTransition();
                photoList.setPhoto(photoList.getNextPhoto(Direction.LEFT));
            }
            else if(centerPosition < -TRANSITION_THRESHOLD) {
                left.setTranslateX(right.getTranslateX() + calculateRightXPosition());
                rightTransition();
                photoList.setPhoto(photoList.getNextPhoto(Direction.RIGHT));
            }
            else {
                centerTransition();
            }
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

    private void snapshottingXPosition() {
        for(int i = 0; i < xSnapshots.length; i++) {
            xSnapshots[i] = photoViewControllers.get(i).getParentPane().getTranslateX();
        }
    }

    private void moveXPositions(double offset) {
        for(int i = 0; i < xSnapshots.length; i++) {
            double newX = xSnapshots[i] + offset;
            photoViewControllers.get(i).getParentPane().setTranslateX(newX);

            xSnapshots[i] = newX;
        }
    }

    private void centerTransition() {
        var center = photoViewControllers.get(centerIndex).getParentPane();
        var offset = center.getTranslateX();

        var centerTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), center);
        centerTransition.setFromX(offset);
        centerTransition.setToX(0);

        var left = photoViewControllers.getLeft(centerIndex).getParentPane();
        var leftTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), left);
        leftTransition.setFromX(left.getTranslateX());
        leftTransition.setToX(left.getTranslateX() - offset);

        var right = photoViewControllers.getRight(centerIndex).getParentPane();
        var rightTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), right);
        rightTransition.setFromX(right.getTranslateX());
        rightTransition.setToX(right.getTranslateX() - offset);

        var parallelTransition = new ParallelTransition(centerTransition, leftTransition, rightTransition);
        parallelTransition.setOnFinished(event -> inTransitionMode = false);

        inTransitionMode = true;
        parallelTransition.play();
    }

    private void leftTransition() {
        var left = photoViewControllers.getLeft(centerIndex);
        centerIndex = photoViewControllers.indexOf(left);
        centerTransition();
    }

    private void rightTransition() {
        var right = photoViewControllers.getRight(centerIndex);
        centerIndex = photoViewControllers.indexOf(right);
        centerTransition();
    }

    private double calculateLeftXPosition() {
        return - view.getWidth() - GAP;
    }

    private double calculateRightXPosition() {
        return view.getWidth() + GAP;
    }
}