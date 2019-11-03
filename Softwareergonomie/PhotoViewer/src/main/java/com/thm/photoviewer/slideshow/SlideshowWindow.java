package com.thm.photoviewer.slideshow;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SlideshowWindow {

    private Stage stage;
    private Scene scene;
    private Slideshow slideshow;

    public SlideshowWindow() {
        stage = new Stage();
        stage.setMinHeight(400);
        stage.setMinWidth(600);

        slideshow = new Slideshow();
        scene = new Scene(slideshow);
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }

}
