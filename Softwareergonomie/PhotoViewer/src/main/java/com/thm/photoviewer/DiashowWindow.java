package com.thm.photoviewer;

import com.thm.photoviewer.controller.Diashow;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class DiashowWindow {

    private Stage stage;
    private Scene scene;
    private Diashow diashow;

    public DiashowWindow() {
        stage = new Stage();

        diashow = new Diashow(stage);
        scene = new Scene(diashow);
        stage.setScene(scene);

        stage.showingProperty().addListener((observable, oldValue, newValue) -> showingChanged(newValue));
    }

    public void show() {
        stage.show();
    }

    private void showingChanged(Boolean showing) {
        if(showing) {
            diashow.start();
        }
        else {
            diashow.stop();
        }
    }

}
