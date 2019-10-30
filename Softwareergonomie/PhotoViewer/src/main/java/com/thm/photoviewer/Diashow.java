package com.thm.photoviewer;

import com.thm.photoviewer.controller.PhotoCell;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import javafx.animation.*;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Diashow extends Stage {

    private PhotoList photoList;
    private double duration = 2;

    private Scene scene;
    private StackPane stackPane;

    public Diashow(PhotoList photoList) {
        this.photoList = photoList;

        super.setMinWidth(600);
        super.setMinHeight(400);

        stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: #000");

        scene = new Scene(stackPane);
        super.setScene(scene);

        super.getScene().addEventFilter(KeyEvent.KEY_PRESSED, event -> onKeyPressed(event));
        super.showingProperty().addListener((observable, oldValue, newValue) -> showingChanged(newValue));
    }

    private void showingChanged(Boolean showing) {
        if(showing) {
            startDiashow();
        }
    }

    private void onKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE) {
            super.close();
        }
    }

    private void startDiashow() {
        var first = createPhotoView(photoList.getSelectedPhoto());
        first.setOpacity(1);
        photoList.setSelectedPhoto(first.getPhoto());

        var second = createPhotoView(photoList.getNextPhoto(Direction.RIGHT));
        second.setOpacity(0);

        stackPane.getChildren().addAll(first, second);

        transition(first, second);
    }

    private void transition(PhotoCell first, PhotoCell second) {
        var fadeout = new FadeTransition(Duration.seconds(duration), first);
        fadeout.setFromValue(1);
        fadeout.setToValue(0);

        var fadein = new FadeTransition(Duration.seconds(duration), second);
        fadein.setFromValue(0);
        fadein.setToValue(1);

        var parallel = new ParallelTransition(fadein, fadeout);
        parallel.setOnFinished(event -> {
            if(super.isShowing() == false) {
                return;
            }

            var currentPhoto = photoList.getNextPhoto(Direction.RIGHT);
            if(second.getPhoto().equals(currentPhoto) == false) {
                second.setPhoto(currentPhoto);
            }

            photoList.setSelectedPhoto(currentPhoto);
            first.setPhoto(photoList.getNextPhoto(Direction.RIGHT));

            var delay = new PauseTransition(Duration.seconds(duration));
            delay.setOnFinished(event1 -> transition(second, first));
            delay.playFromStart();
        });

        parallel.playFromStart();
    }

    private PhotoCell createPhotoView(Photo photo) {
        var photoCell = new PhotoCell();
        photoCell.setPhoto(photo);
        return photoCell;
    }

}
