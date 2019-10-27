package com.thm.photoviewer.controller;

import com.thm.common.ImageChooser;
import com.thm.photoviewer.models.PhotoList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class BottomBarController implements Initializable {

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
}
