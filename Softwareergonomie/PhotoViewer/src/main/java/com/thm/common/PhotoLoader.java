package com.thm.common;

import com.thm.photoviewer.models.Photo;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.File;
import java.util.List;

public class PhotoLoader {

    private int count;

    public void start(List<File> files) {
        count = 0;
        finishedProperty.setValue(false);

        for(var f : files) {
            var reader = new PhotoReader(f);
            reader.setOnSucceeded(event -> {
                photoProperty.set(reader.getValue());
                count++;
                if(count == files.size()) {
                    finishedProperty.setValue(true);
                }
            });
            reader.start();
        }
    }

    private ObjectProperty<Photo> photoProperty = new SimpleObjectProperty<>();
    public ObjectProperty<Photo> photoProperty() {
        return photoProperty;
    }

    private BooleanProperty finishedProperty = new SimpleBooleanProperty(true);
    public BooleanProperty finishedProperty() {
        return finishedProperty;
    }

}
