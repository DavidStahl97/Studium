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
            var photo = imageChooser.show(window);
            photoList.addAll(photo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
