package com.thm.common;

import com.thm.photoviewer.models.Photo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class ImageChooser {

    private Preferences preferences;

    private static final String LAST_FOLDER = "LAST_FOLDER";

    public ImageChooser() {
        preferences = Preferences.userRoot().node(this.getClass().getName());
    }

    public List<Photo> show(Window window) throws IOException {
        var folder = preferences.get(LAST_FOLDER, new File(".").getAbsolutePath());
        var fileChooser = createFileChooser(folder);

        var files = fileChooser.showOpenMultipleDialog(window);
        if(files.size() > 0) {
            preferences.put(LAST_FOLDER, files.get(0).getParent());
        }

        var photos = new ArrayList<Photo>();
        for (var file : files) {
            //compress(file);

            var inputStream = new FileInputStream(file.getAbsoluteFile());
            var image = new Image(inputStream);
            var compressedImage = resize(file, 200);

            var photo = new Photo(image, compressedImage, file.getName());
            photos.add(photo);
        }

        return photos;
    }

    private Image resize(File inputFile, int scaledHeight)
            throws IOException {
        BufferedImage inputImage = ImageIO.read(inputFile);

        double ratio = (double)inputImage.getWidth() / inputImage.getHeight();
        int scaledWidth = (int) (ratio * scaledHeight);

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        return convertToFxImage(outputImage);
    }

    private Image convertToFxImage(BufferedImage image) {
        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }

        return new ImageView(wr).getImage();
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
