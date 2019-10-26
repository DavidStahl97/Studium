package com.thm.javafxmvc.selection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LightApp extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        final Bulb[] bulbs = {
                new Bulb(),
                new Bulb(),
                new Bulb()
        };

        Scene scene = new Scene(new LightArray(bulbs));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
