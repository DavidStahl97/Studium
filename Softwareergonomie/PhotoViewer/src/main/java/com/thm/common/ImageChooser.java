package com.thm.common;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.prefs.Preferences;

public class ImageChooser {

    private Preferences preferences;

    private static final String LAST_FOLDER = "LAST_FOLDER";

    public ImageChooser() {
        preferences = Preferences.userRoot().node(this.getClass().getName());
    }

    public List<File> show(Window window) throws IOException {
        var folder = preferences.get(LAST_FOLDER, new File(".").getAbsolutePath());
        var fileChooser = createFileChooser(folder);

        var files = fileChooser.showOpenMultipleDialog(window);
        if(files.size() > 0) {
            preferences.put(LAST_FOLDER, files.get(0).getParent());
        }

        return files;
    }

    // To-Do: Handling exiting fileChooser
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
