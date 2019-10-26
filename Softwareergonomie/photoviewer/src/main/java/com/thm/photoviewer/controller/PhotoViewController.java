package com.thm.photoviewer.controller;

import com.thm.ModuloArray;
import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.views.PhotoView;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Arrays;

public class PhotoViewController extends ControllerBase<PhotoView> {
    private static final double TRANSITION_DURATION = 0.4;
    private static final int GAP = 10;
    private static final double TRANSITION_THRESHOLD = 100.0;

    private PhotoList photoList;

    private ModuloArray<ImageView> imageViews;
    private double[] xSnapshots;
    private int centerIndex = 0;

    private double orgSceneX;
    private boolean inTransitionMode = false;
    private boolean startDragging = false;

    public PhotoViewController(PhotoList photoList) {
        super(PhotoView.class);

        imageViews = new ModuloArray<>();
        imageViews.addAll(Arrays.asList(view.getImageViews()));
        xSnapshots = new double[imageViews.size()];

        clipChildren(view, 12);
        for(var imageView : imageViews) {
            configureImageView(imageView);
        }
        configureXPositionResizingUpdates();

        this.photoList = photoList;
        photoList.selectedPhotoProperty().addListener((observable, oldValue, newValue) -> onSelectedPhoto(newValue));
    }

    private void configureXPositionResizingUpdates() {
        view.widthProperty().addListener((observable, oldValue, newValue) -> {
            var left = imageViews.getLeft(centerIndex);
            left.setTranslateX(calculateLeftXPosition());

            var right = imageViews.getRight(centerIndex);
            right.setTranslateX(calculateRightXPosition());
        });
    }

    private void onSelectedPhoto(Photo p) {
        if(p == null) {
            imageViews.stream().forEach(imageView -> imageView.setImage(null));
            return;
        }

        if(p.getImage().equals(imageViews.get(centerIndex).getImage())) {
            return;
        }

        var center = imageViews.get(centerIndex);
        var left = imageViews.getLeft(centerIndex);
        var right = imageViews.getRight(centerIndex);

        left.setTranslateX(calculateLeftXPosition());
        right.setTranslateX(calculateRightXPosition());

        center.setImage(p.getImage());
        left.setImage(photoList.getNextPhoto(Direction.LEFT).getImage());
        right.setImage(photoList.getNextPhoto(Direction.RIGHT).getImage());

        for(var view : imageViews) {
            setImageRatio(view);
        }
    }

    private void setImageRatio(ImageView imageView) {
        var image = imageView.getImage();
        if(image.getWidth() > image.getHeight()) {
            imageView.fitWidthProperty().bind(view.widthProperty());
            imageView.fitHeightProperty().unbind();
        }
        else {
            imageView.fitHeightProperty().bind(view.heightProperty());
            imageView.fitWidthProperty().unbind();
        }

        imageView.setPreserveRatio(true);
    }

    private void configureImageView(ImageView imageView) {
        imageView.setCursor(Cursor.HAND);

        imageView.addEventFilter(MouseEvent.MOUSE_PRESSED, t -> {
            if(inTransitionMode) {
                startDragging = false;
                return;
            }

            startDragging = true;

            orgSceneX = t.getSceneX();
            snapshottingXPosition();
        });

        imageView.setOnMouseDragged(t -> {
            if(startDragging == false) {
                return;
            }

            double offsetX = t.getSceneX() - orgSceneX;
            orgSceneX = t.getSceneX();

            var left = imageViews.getLeft(centerIndex);
            var right = imageViews.getRight(centerIndex);
            if((left.getTranslateX() > -10 && offsetX > 0)
                    || (right.getTranslateX() < 10 && offsetX < 0)) {
                return;
            }

            moveXPositions(offsetX);
        });

        imageView.addEventFilter(MouseEvent.MOUSE_RELEASED, t -> {
            if(startDragging == false) {
                return;
            }

            var center = imageViews.get(centerIndex);
            var centerPosition = center.getTranslateX();
            var paneWidth = view.getWidth();

            var right = imageViews.getRight(centerIndex);
            var left = imageViews.getLeft(centerIndex);
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
            xSnapshots[i] = imageViews.get(i).getTranslateX();
        }
    }

    private void moveXPositions(double offset) {
        for(int i = 0; i < xSnapshots.length; i++) {
            double newX = xSnapshots[i] + offset;
            imageViews.get(i).setTranslateX(newX);

            xSnapshots[i] = newX;
        }
    }

    private void centerTransition() {
        var offset = imageViews.get(centerIndex).getTranslateX();

        var centerTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), imageViews.get(centerIndex));
        centerTransition.setFromX(offset);
        centerTransition.setToX(0);

        var left = imageViews.getLeft(centerIndex);
        var leftTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), left);
        leftTransition.setFromX(left.getTranslateX());
        leftTransition.setToX(left.getTranslateX() - offset);

        var right = imageViews.getRight(centerIndex);
        var rightTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), right);
        rightTransition.setFromX(right.getTranslateX());
        rightTransition.setToX(right.getTranslateX() - offset);

        var parallelTransition = new ParallelTransition(centerTransition, leftTransition, rightTransition);
        parallelTransition.setOnFinished(event -> inTransitionMode = false);

        inTransitionMode = true;
        parallelTransition.play();
    }

    private void leftTransition() {
        var left = imageViews.getLeft(centerIndex);
        centerIndex = imageViews.indexOf(left);
        centerTransition();
    }

    private void rightTransition() {
        var right = imageViews.getRight(centerIndex);
        centerIndex = imageViews.indexOf(right);
        centerTransition();
    }

    private double calculateLeftXPosition() {
        return - view.getWidth() - GAP;
    }

    private double calculateRightXPosition() {
        return view.getWidth() + GAP;
    }
}