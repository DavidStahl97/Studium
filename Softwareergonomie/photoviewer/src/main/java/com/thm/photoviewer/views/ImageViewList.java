package com.thm.photoviewer.views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageViewList {
    private static final int SIZE = 3;

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
        int i = (centerIndex + imageViews.length - 1) % imageViews.length;
        return imageViews[i];
    }

    public ImageView getRightImageView() {
        int i = (centerIndex + 1) % imageViews.length;
        return imageViews[i];
    }

    public void deleteImages() {
        for(var view : imageViews) {
            view.setImage(null);
        }
    }

    public void snapshotingXPosition() {
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

    public ImageView[] getImageViews() {
        return imageViews;
    }
}
