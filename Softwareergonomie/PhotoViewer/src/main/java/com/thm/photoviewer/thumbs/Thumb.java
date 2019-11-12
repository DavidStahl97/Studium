package com.thm.photoviewer.thumbs;

import com.thm.common.InjectionService;
import com.thm.photoviewer.photoview.PhotoCell;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Thumb extends AnchorPane {

    private PhotoList photoList;

    private PhotoCell photoCell;
    private Photo photo;

    public Thumb() {
        photoCell = new PhotoCell();
        photoCell.setMaxHeight(100);
        photoCell.setPrefHeight(100);
        super.getChildren().add(photoCell);

        // To-Do: shouldn't use photoList
        photoList = InjectionService.getInstance().getSingleton(PhotoList.class);

        super.setCursor(Cursor.HAND);
        super.addEventFilter(MouseEvent.MOUSE_PRESSED, t -> photoList.setSelectedPhoto(photo));
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        photoCell.setImage(photo.getCompressedImage());
    }

    public Photo getPhoto() {
        return photo;
    }
}
