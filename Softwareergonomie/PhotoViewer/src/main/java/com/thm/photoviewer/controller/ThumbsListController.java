package com.thm.photoviewer.controller;

import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ThumbsListController implements Initializable {

    private PhotoList photoList;

    @FXML
    private HBox thumbsBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        photoList = PhotoList.getPhotoList();
        photoList.addListener((ListChangeListener<? super Photo>) c -> photoListChanged(c));
    }

    private void photoListChanged(ListChangeListener.Change<? extends Photo> c) {
        while(c.next()) {
            for(var photo : c.getAddedSubList()) {
                var thumb = new Thumb();
                thumb.setPhoto(photo);
                thumbsBox.getChildren().add(thumb);
            }
        }
    }
}
