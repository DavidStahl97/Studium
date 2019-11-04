package com.thm.photoviewer;

import com.thm.common.InjectionService;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.models.Zooming;
import com.thm.photoviewer.thumbs.ThumbList;
import com.thm.photoviewer.thumbs.ThumbsListController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        register();

        var scene = new Scene(new Shell());

        stage.setTitle("Photo Viewer");
        stage.setMinHeight(400);
        stage.setMinWidth(600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        launch();
    }

    private void register() {
        var injectionService = InjectionService.getInstance();
        injectionService.registerSingleton(PhotoList.class);
        injectionService.registerSingleton(Zooming.class);
    }

}