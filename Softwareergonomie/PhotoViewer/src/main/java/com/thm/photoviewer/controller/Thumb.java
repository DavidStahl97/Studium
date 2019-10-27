package com.thm.photoviewer.controller;

import com.thm.photoviewer.App;
import com.thm.photoviewer.models.Photo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Thumb extends AnchorPane implements Initializable {

    @FXML
    private PhotoCell photoCell;

    public Thumb() {
        var url = App.class.getResource("thumb" + ".fxml");
        var fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setPhoto(Photo photo) {
        photoCell.setPhoto(photo);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
