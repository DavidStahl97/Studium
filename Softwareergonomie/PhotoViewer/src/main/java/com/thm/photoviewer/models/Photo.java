package com.thm.photoviewer.models;

import javafx.scene.image.Image;

public class Photo {

    private Image image;
    private Image compressedImage;
    private String name;

    public Photo(Image image, Image compressedImage, String name) {
        this.image = image;
        this.name = name;
        this.compressedImage = compressedImage;
    }

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public Image getCompressedImage() {
        return compressedImage;
    }
}
