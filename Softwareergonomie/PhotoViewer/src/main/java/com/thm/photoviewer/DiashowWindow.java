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
        diashow = new Diashow();
        scene = new Scene(diashow);
        stage = new Stage();
        stage.setScene(scene);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> onKeyPressed(event));
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

    private void onKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE) {
            stage.close();
        }
    }

}
