package com.thm.common;

import com.thm.photoviewer.models.Photo;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class PhotoReader extends Service<Photo> {

    private File file;

    public PhotoReader(File file) {
        this.file = file;
    }

    @Override
    protected Task<Photo> createTask() {
        return new Task<>() {
            @Override
            protected Photo call() throws Exception {
                var bytes = Files.readAllBytes(file.toPath());
                var inputStream = new ByteArrayInputStream(bytes);
                var compressed = resize(inputStream, 200);
                inputStream.reset();
                var image = new Image(inputStream);

                return new Photo(image, compressed, file.getName());
            }
        };
    }

    private Image resize(InputStream inputStream, int scaledHeight)
            throws IOException {
        BufferedImage inputImage = ImageIO.read(inputStream);

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

}
