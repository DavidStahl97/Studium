package com.thm.photoviewer.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;

public class PhotoList extends SimpleListProperty<Photo> {

    private ObjectProperty<Photo> selectedPhoto = new SimpleObjectProperty<>();

    public PhotoList() {
        super(FXCollections.observableArrayList());
    }

    public Photo getPhoto() {
        return selectedPhoto.get();
    }

    public void setPhoto(Photo photo) {
        selectedPhoto.set(photo);
    }

    public ObjectProperty<Photo> selectedPhotoProperty() {
        return selectedPhoto;
    }

    public void nextPhoto(Direction direction) {
        var currentIndex = super.indexOf(selectedPhoto);
        var size = size();
        var newIndex = direction == Direction.RIGHT ?
                (currentIndex + 1) % size :
                (size + currentIndex - 1) % size;

        var currentPhoto = super.get(newIndex);
        setPhoto(currentPhoto);
    }
}
