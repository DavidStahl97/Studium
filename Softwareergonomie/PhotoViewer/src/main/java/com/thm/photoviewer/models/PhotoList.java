package com.thm.photoviewer.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;

// TO-DO: use ModuloArray
public class PhotoList extends SimpleListProperty<Photo> {

    private static PhotoList photoList;
    public static PhotoList getPhotoList() {
        if(photoList == null) {
            photoList = new PhotoList();
        }

        return photoList;
    }

    private ObjectProperty<Photo> selectedPhoto = new SimpleObjectProperty<>();

    private PhotoList() {
        super(FXCollections.observableArrayList());
    }

    public Photo getSelectedPhoto() {
        return selectedPhoto.get();
    }

    public void setSelectedPhoto(Photo photo) {
        selectedPhoto.set(photo);
    }

    public ObjectProperty<Photo> selectedPhotoProperty() {
        return selectedPhoto;
    }

    public void removeSelectedPhoto() {
        var left = getNextPhoto(Direction.LEFT);
        super.remove(getSelectedPhoto());
        if(super.size() > 1) {
            setSelectedPhoto(left);
        }
    }

    public Photo getNextPhoto(Direction direction) {
        var currentIndex = indexOf(getSelectedPhoto());
        var size = size();
        var newIndex = direction == Direction.RIGHT ?
                (currentIndex + 1) % size :
                (size + currentIndex - 1) % size;

        var nextPhoto = get(newIndex);
        return nextPhoto;
    }

    public Photo getPhoto(int index) {
        return super.get(index % size());
    }
}
