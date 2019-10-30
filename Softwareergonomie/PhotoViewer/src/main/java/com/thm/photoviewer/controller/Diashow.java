package com.thm.photoviewer.controller;

import com.thm.photoviewer.App;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.PhotoList;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Diashow extends StackPane implements Initializable {

    private PhotoList photoList;

    private static final double SLIDER_RATIO = 10;
    private double duration = 2;

    private boolean isShowing = false;

    @FXML
    private PhotoCell photoCellOne;

    @FXML
    private PhotoCell photoCellTwo;

    @FXML
    private Slider slider;

    public Diashow() {
        var url = App.class.getResource("diashow" + ".fxml");
        var fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        photoList = PhotoList.getPhotoList();
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            duration = (newValue.doubleValue() + 1) / SLIDER_RATIO;
        });
    }

    public void start() {
        isShowing = true;

        photoCellOne.setPhoto(photoList.getSelectedPhoto());
        photoCellTwo.setPhoto(photoList.getNextPhoto(Direction.RIGHT));
        transition(photoCellOne, photoCellTwo);
    }

    public void stop() {
        isShowing = false;
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
            if(isShowing == false) {
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
}
