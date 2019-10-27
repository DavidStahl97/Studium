package com.thm.common;

import com.thm.photoviewer.models.Photo;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ImageChooser {

    private FileChooser fileChooser;

    public ImageChooser() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }

    public List<Photo> show(Window window) throws FileNotFoundException {
        var files = fileChooser.showOpenMultipleDialog(window);

        var photos = new ArrayList<Photo>();
        for (var file : files) {
            var inputStream = new FileInputStream(file.getAbsoluteFile());
            var image = new Image(inputStream);

            var photo = new Photo(image, file.getName());
            photos.add(photo);
        }

        return photos;
    }

}
