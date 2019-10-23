package com.thm.photoviewer;

import com.thm.eventbus.EventAggregator;
import com.thm.photoviewer.controller.PhotoViewController;
import com.thm.photoviewer.controller.ShellController;
import com.thm.photoviewer.controller.ThumbListController;
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

        var thumbListController = new ThumbListController(eventAggregator);
        var photoViewController = new PhotoViewController(eventAggregator);
        var shellController = new ShellController(thumbListController, photoViewController);

        var scene = new Scene(shellController.getParentPane(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}