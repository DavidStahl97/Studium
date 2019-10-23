package com.thm.photoviewer.views;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PhotoView extends Pane {

    private ImageView imageView;

    public PhotoView() {
        imageView = new ImageView();
        imageView.fitWidthProperty().bind(super.widthProperty());
        imageView.fitHeightProperty().bind(super.heightProperty());
        super.getChildren().add(imageView);
    }

    public ImageView getImageView() {
        return imageView;
    }

}
