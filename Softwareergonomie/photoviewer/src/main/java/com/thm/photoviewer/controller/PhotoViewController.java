package com.thm.photoviewer.controller;

import com.thm.common.ModuloArray;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class PhotoViewController implements Initializable {
    private static final double TRANSITION_DURATION = 0.2;
    private static final int GAP = 10;
    private static final double TRANSITION_THRESHOLD = 100.0;
    private static final int PHOTO_VIEW_COUNT = 3;

    private PhotoList photoList;

    private ModuloArray<PhotoCell> photoCells;
    private double[] xSnapshots;
    private int centerIndex = 0;

    private double orgSceneX;
    private boolean inTransitionMode = false;
    private boolean startDragging = false;

    @FXML
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        photoList = PhotoList.getPhotoList();

        createPhotoCells();
        xSnapshots = new double[photoCells.size()];

        clipChildren(pane, 12);
        configureXPositionResizingUpdates();

        photoList.selectedPhotoProperty().addListener((observable, oldValue, newValue) -> onSelectedPhoto(newValue));
        photoList.addListener((ListChangeListener<? super Photo>) c -> photoListChanged());
    }

    private void onSelectedPhoto(Photo p) {
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

    private void createPhotoCells() {
        photoCells = new ModuloArray<>();

        for(int i = 0; i < PHOTO_VIEW_COUNT; i++) {
            var photoCell = new PhotoCell();
            configurePhotoView(photoCell);
            photoCells.add(photoCell);

            pane.getChildren().add(photoCell);
            photoCell.prefWidthProperty().bind(pane.widthProperty());
            photoCell.prefHeightProperty().bind(pane.heightProperty());
        }
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

            var left = photoCells.getLeft(centerIndex);
            var right = photoCells.getRight(centerIndex);
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
        });
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
        return - pane.getWidth() - GAP;
    }

    private double calculateRightXPosition() {
        return pane.getWidth() + GAP;
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
        pane.widthProperty().addListener((observable, oldValue, newValue) -> {
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
