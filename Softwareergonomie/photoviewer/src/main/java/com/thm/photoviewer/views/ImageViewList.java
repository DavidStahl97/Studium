package com.thm.photoviewer.views;

import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

// TO-DO: Implement Restklassen-Liste
// TO-DO: Use MVC-Pattern
public class ImageViewList {
    private static final int SIZE = 3;
    private static final double OFFSET_PER_SECONDS = 900.0;

    private ImageView[] imageViews;
    private double[] xSnapshots;
    private int centerIndex = 0;

    public ImageViewList() {
        this.imageViews = new ImageView[3];
        this.xSnapshots = new double[3];
        for(int i = 0; i < SIZE; i++) {
            imageViews[i] = new ImageView();
        }
    }

    public ImageView getCenterImageView() {
        return imageViews[centerIndex];
    }

    public ImageView getLeftImageView() {
        int i = getLeftIndex();
        return imageViews[i];
    }

    public ImageView getRightImageView() {
        int i = getRightIndex();
        return imageViews[i];
    }

    public void deleteImages() {
        for(var view : imageViews) {
            view.setImage(null);
        }
    }

    public void snapshottingXPosition() {
        for(int i = 0; i < SIZE; i++) {
            xSnapshots[i] = imageViews[i].getTranslateX();
        }
    }

    public void moveXPositions(double offset) {
        for(int i = 0; i < SIZE; i++) {
            double snapshot = xSnapshots[i];
            double newX = snapshot + offset;
            imageViews[i].setTranslateX(newX);

            xSnapshots[i] = newX;
        }
    }

    public void centerTransition() {
        var offset = getCenterImageView().getTranslateX();
        var duration = Math.abs(offset / OFFSET_PER_SECONDS);

        var centerTransition = new TranslateTransition(Duration.seconds(duration), getCenterImageView());
        centerTransition.setFromX(offset);
        centerTransition.setToX(0);

        var left = getLeftImageView();
        var leftTransition = new TranslateTransition(Duration.seconds(duration), left);
        leftTransition.setFromX(left.getTranslateX());
        leftTransition.setToX(left.getTranslateX() - offset);

        var right = getRightImageView();
        var rightTransition = new TranslateTransition(Duration.seconds(duration), right);
        rightTransition.setFromX(right.getTranslateX());
        rightTransition.setToX(right.getTranslateX() - offset);

        var parallelTransition = new ParallelTransition(centerTransition, leftTransition, rightTransition);
        parallelTransition.play();
    }

    public void leftTransition() {
        centerIndex = getLeftIndex();
        centerTransition();
    }

    public void rightTransition() {
        centerIndex = getRightIndex();
        centerTransition();
    }

    public ImageView[] getImageViews() {
        return imageViews;
    }

    private int getLeftIndex() {
        return (centerIndex + imageViews.length - 1) % imageViews.length;
    }

    private int getRightIndex() {
        return (centerIndex + 1) % imageViews.length;
    }
}
