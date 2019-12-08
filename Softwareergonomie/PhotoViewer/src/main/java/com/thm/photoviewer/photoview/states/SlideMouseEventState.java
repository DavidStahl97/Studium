package com.thm.photoviewer.photoview.states;

import com.thm.common.ModuloArray;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.photoview.PhotoCell;
import com.thm.photoviewer.photoview.PhotoViewController;
import com.thm.photoviewer.photoview.PhotoViewer;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class SlideMouseEventState extends MouseEventState {

    private static final double TRANSITION_THRESHOLD = 100.0;
    private static final double TRANSITION_DURATION = 0.2;

    private PhotoList photoList;

    private double[] xSnapshots;
    private boolean inTransitionMode = false;
    private boolean startDragging = false;

    public SlideMouseEventState(ModuloArray<PhotoCell> photoCells, PhotoViewer photoViewer, PhotoList photoList) {
        super(photoCells, photoViewer);

        this.photoList = photoList;
        this.xSnapshots = new double[photoCells.size()];
    }

    @Override
    public void OnMousePressed() {
        if(inTransitionMode) {
            startDragging = false;
            return;
        }

        startDragging = true;
        snapshottingXPosition();
    }

    @Override
    public void OnMouseDragged(double offsetX, double offsetY) {
        if(startDragging == false) {
            return;
        }

        var left = photoCells.getLeft();
        var right = photoCells.getRight();
        if((left.getTranslateX() > -10 && offsetX > 0)
                || (right.getTranslateX() < 10 && offsetX < 0)) {
            return;
        }

        moveXPositions(offsetX);
    }

    @Override
    public void OnMouseReleased() {
        transitionMouseReleased();
    }

    private void transitionMouseReleased() {
        if(startDragging == false) {
            return;
        }

        var center = photoCells.getCenter();
        var centerPosition = center.getTranslateX();

        var right = photoCells.getRight();
        var left = photoCells.getLeft();
        if(centerPosition > TRANSITION_THRESHOLD) {
            right.setTranslateX(left.getTranslateX() + PhotoViewController.calculateLeftXPosition(view));
            // new centerIndex is the old left index
            leftTransition();
            photoList.setSelectedPhoto(photoList.getNextPhoto(Direction.LEFT));

            // the old left image is now the center image, so a new left image must be loaded
            var leftController = photoCells.getLeft();
            leftController.setImage(photoList.getNextPhoto(Direction.LEFT).getImage());
        }
        else if(centerPosition < -TRANSITION_THRESHOLD) {
            left.setTranslateX(right.getTranslateX() + PhotoViewController.calculateRightXPosition(view));
            // new centerIndex is the old right index
            rightTransition();
            photoList.setSelectedPhoto(photoList.getNextPhoto(Direction.RIGHT));

            // the old right image is now the center image, so a new right image must be loaded
            var rightController = photoCells.getRight();
            rightController.setImage(photoList.getNextPhoto(Direction.RIGHT).getImage());
        }
        else {
            centerTransition();
        }
    }

    private void centerTransition() {
        var center = photoCells.getCenter();
        var offset = center.getTranslateX();

        var centerTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), center);
        centerTransition.setFromX(offset);
        centerTransition.setToX(0);

        var left = photoCells.getLeft();
        var leftTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), left);
        leftTransition.setFromX(left.getTranslateX());
        leftTransition.setToX(left.getTranslateX() - offset);

        var right = photoCells.getRight();
        var rightTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), right);
        rightTransition.setFromX(right.getTranslateX());
        rightTransition.setToX(right.getTranslateX() - offset);

        var parallelTransition = new ParallelTransition(centerTransition, leftTransition, rightTransition);
        parallelTransition.setOnFinished(event -> inTransitionMode = false);

        inTransitionMode = true;
        parallelTransition.play();
    }

    private void leftTransition() {
        var left = photoCells.getLeft();
         photoCells.setCenterIndex(photoCells.indexOf(left));
        centerTransition();
    }

    private void rightTransition() {
        var right = photoCells.getRight();
        photoCells.setCenterIndex(photoCells.indexOf(right));
        centerTransition();
    }

    private void moveXPositions(double offset) {
        for(int i = 0; i < xSnapshots.length; i++) {
            double newX = xSnapshots[i] + offset;
            photoCells.get(i).setTranslateX(newX);

            xSnapshots[i] = newX;
        }
    }

    private void snapshottingXPosition() {
        for(int i = 0; i < xSnapshots.length; i++) {
            xSnapshots[i] = photoCells.get(i).getTranslateX();
        }
    }
}