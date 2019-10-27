package com.thm.photoviewer;

import com.thm.photoviewer.controller.BottomController;
import com.thm.photoviewer.controller.ShowPhotosController;
import com.thm.photoviewer.controller.ShellController;
import com.thm.photoviewer.models.PhotoList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var photoList = new PhotoList();

        //var thumbListController = new ThumbListController(photoList);
        var bottomController = new BottomController(photoList);
        var photoViewController = new ShowPhotosController(photoList);
        var shellController = new ShellController(bottomController, photoViewController);

        var scene = new Scene(shellController.getParentPane(), 640, 480);
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setTitle("Photo Viewer");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}