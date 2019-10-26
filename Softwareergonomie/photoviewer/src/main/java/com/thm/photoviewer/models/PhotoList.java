package com.thm.photoviewer.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;

public class PhotoList extends SimpleListProperty<Photo> {

    private ObjectProperty<Photo> selectedPhoto = new SimpleObjectProperty<>();

    public PhotoList() {
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
}
