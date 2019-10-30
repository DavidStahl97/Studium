package com.thm.common;

import com.thm.photoviewer.models.Photo;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.*;

public class ImageChooser {

    private Preferences preferences;

    private static final String LAST_FOLDER = "LAST_FOLDER";

    public ImageChooser() {
        preferences = Preferences.userRoot().node(this.getClass().getName());
    }

    public List<Photo> show(Window window) throws FileNotFoundException {
        var folder = preferences.get(LAST_FOLDER, new File(".").getAbsolutePath());
        var fileChooser = createFileChooser(folder);

        var files = fileChooser.showOpenMultipleDialog(window);
        if(files.size() > 0) {
            preferences.put(LAST_FOLDER, files.get(0).getParent());
        }

        var photos = new ArrayList<Photo>();
        for (var file : files) {
            var inputStream = new FileInputStream(file.getAbsoluteFile());
            var image = new Image(inputStream);

            var photo = new Photo(image, file.getName());
            photos.add(photo);
        }

        return photos;
    }

    private FileChooser createFileChooser(String lastFolder) {
        var fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(lastFolder));
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        return fileChooser;
    }

}
