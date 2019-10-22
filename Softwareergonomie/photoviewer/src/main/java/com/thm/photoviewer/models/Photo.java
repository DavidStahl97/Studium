package com.thm.photoviewer.models;

import javafx.scene.image.Image;

public class Photo {

    private Image image;
    private String name;

    public Photo(Image image, String name) {
        this.image = image;
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

}
