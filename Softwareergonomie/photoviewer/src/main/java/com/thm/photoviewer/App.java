package com.thm.photoviewer;

import com.thm.eventbus.EventAggregator;
import com.thm.photoviewer.controller.FunctionalityController;
import com.thm.photoviewer.controller.PhotoViewController;
import com.thm.photoviewer.controller.ShellController;
import com.thm.photoviewer.controller.ThumbListController;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.views.PhotoView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var eventAggregator = new EventAggregator();

        var photoList = new PhotoList();

        var functionalityController = new FunctionalityController(eventAggregator);
        var thumbListController = new ThumbListController(photoList);
        var photoViewController = new PhotoViewController(photoList);
        var shellController = new ShellController(thumbListController, photoViewController, functionalityController);

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