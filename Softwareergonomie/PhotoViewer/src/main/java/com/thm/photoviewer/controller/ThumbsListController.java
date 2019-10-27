package com.thm.photoviewer.controller;

import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ThumbsListController implements Initializable {

    private static final double OPACITY = 0.5;

    private PhotoList photoList;

    @FXML
    private HBox thumbsBox;

    @FXML
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        photoList = PhotoList.getPhotoList();
        photoList.addListener((ListChangeListener<? super Photo>) c -> photoListChanged(c));
        photoList.selectedPhotoProperty().addListener((observable, oldValue, newValue) -> onSelectedPhotoChanged(newValue));

        pane.widthProperty().addListener((observable, oldValue, newValue) -> alignThumbBox(newValue.doubleValue()));
        thumbsBox.widthProperty().addListener((observable, oldValue, newValue) -> alignThumbBox(pane.getWidth()));
    }

    private void onSelectedPhotoChanged(Photo selectedPhoto) {
        if(selectedPhoto == null) {
            return;
        }

        var photoCell = thumbsBox.getChildren().stream()
                .filter(p -> ((Thumb) p).getPhoto().equals(selectedPhoto))
                .findAny()
                .get();

        var oldOptional = thumbsBox.getChildren().stream()
                .filter(p -> p.getOpacity() == OPACITY)
                .findAny();
        if(oldOptional.isPresent()) {
            oldOptional.get().setOpacity(1);
        }

        photoCell.setOpacity(OPACITY);
    }

    private void alignThumbBox(double newWidth) {
        var thumbWidth = thumbsBox.getWidth();
        if(thumbWidth < 1) {
            return;
        }

        if(thumbWidth < newWidth) {
            var offset = (newWidth - thumbWidth) / 2;
            thumbsBox.setTranslateX(offset);
        }
        else {
            thumbsBox.setTranslateX(0);
        }
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
