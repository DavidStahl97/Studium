package com.thm.photoviewer.thumbs;

import com.thm.photoviewer.photoview.PhotoCell;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Thumb extends AnchorPane {

    private PhotoList photoList;

    private PhotoCell photoCell;

    public Thumb() {
        photoCell = new PhotoCell();
        photoCell.setMaxHeight(100);
        photoCell.setPrefHeight(100);
        super.getChildren().add(photoCell);

        photoList = PhotoList.getPhotoList();

        super.setCursor(Cursor.HAND);
        super.addEventFilter(MouseEvent.MOUSE_PRESSED, t -> photoList.setSelectedPhoto(getPhoto()));
    }

    public void setPhoto(Photo photo) {
        photoCell.setPhoto(photo);
    }

    public Photo getPhoto() {
        return photoCell.getPhoto();
    }
}
