package com.thm.common;

import com.thm.photoviewer.models.Photo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.File;
import java.util.List;

public class PhotoLoader {

    public void start(List<File> files) {
        for(var f : files) {
            var reader = new PhotoReader(f);
            reader.setOnSucceeded(event -> photoProperty.set(reader.getValue()));
            reader.start();
        }
    }

    private ObjectProperty<Photo> photoProperty = new SimpleObjectProperty<>();
    public ObjectProperty<Photo> photoProperty() {
        return photoProperty;
    }

}
