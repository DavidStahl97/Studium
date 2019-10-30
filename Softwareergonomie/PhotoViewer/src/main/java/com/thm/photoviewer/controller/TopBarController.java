package com.thm.photoviewer.controller;

import com.thm.common.ImageChooser;
import com.thm.photoviewer.Diashow;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.PhotoList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class TopBarController implements Initializable {

    private ImageChooser imageChooser = new ImageChooser();
    private PhotoList photoList;

    @FXML
    private Button addButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        photoList = PhotoList.getPhotoList();
    }

    @FXML
    private void onAddPhoto() {
        var window = addButton.getScene().getWindow();
        try {
            var photos = imageChooser.show(window);
            photoList.addAll(photos);

            if(photos.size() > 0 && photoList.getSelectedPhoto() == null) {
                photoList.setSelectedPhoto(photos.get(0));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onRemovePhoto() {
        var left = photoList.getNextPhoto(Direction.LEFT);
        var right = photoList.getNextPhoto(Direction.RIGHT);
        var centerIndex = photoList.indexOf(photoList.getSelectedPhoto());
        photoList.removeSelectedPhoto();
        if(photoList.size() > 0) {
            if(Math.abs(centerIndex - photoList.indexOf(left)) < Math.abs(centerIndex - photoList.indexOf(right))) {
                photoList.setSelectedPhoto(left);
            }
            else {
                photoList.setSelectedPhoto(right);
            }
        }
        else {
            photoList.setSelectedPhoto(null);
        }
    }

    public void onStartDiashow() {
        var diashow = new Diashow(photoList);

        var stage = new Stage();
        stage.setScene(new Scene(diashow));

        stage.show();
        diashow.startDiashow();
    }
}
