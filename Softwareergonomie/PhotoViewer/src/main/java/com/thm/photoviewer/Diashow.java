package com.thm.photoviewer;

import com.thm.photoviewer.controller.PhotoCell;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Diashow extends StackPane {

    private PhotoList photoList;

    private double duration = 2;

    public Diashow(PhotoList photoList) {
        this.photoList = photoList;

        super.setStyle("-fx-background-color: #000");


        //super.getScene().addEventFilter(KeyEvent.KEY_PRESSED, event -> onKeyPressed(event));
    }

    public void startDiashow() {
        var first = createPhotoView(photoList.get(0));
        first.setOpacity(1);
        photoList.setSelectedPhoto(first.getPhoto());

        var second = createPhotoView(photoList.get(1));
        second.setOpacity(0);

        this.getChildren().addAll(first, second);

        start(first, second);
    }

    private void start(PhotoCell first, PhotoCell second) {
        var fadeout = new FadeTransition(Duration.seconds(duration), first);
        fadeout.setFromValue(1);
        fadeout.setToValue(0);

        var fadein = new FadeTransition(Duration.seconds(duration), second);
        fadein.setFromValue(0);
        fadein.setToValue(1);

        var parallel = new ParallelTransition(fadein, fadeout);
        parallel.setOnFinished(event -> {
            photoList.setSelectedPhoto(second.getPhoto());
            first.setPhoto(photoList.getNextPhoto(Direction.RIGHT));

            var delay = new PauseTransition(Duration.seconds(duration));
            delay.setOnFinished(event1 -> start(second, first));
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
