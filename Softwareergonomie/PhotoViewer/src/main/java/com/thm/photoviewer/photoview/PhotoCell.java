package com.thm.photoviewer.photoview;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PhotoCell extends Pane {

    private PhotoCellController controller;

    private ImageView imageView;

    public PhotoCell() {
        imageView = new ImageView();
        super.getChildren().add(imageView);

        setImageRatio(imageView);

        controller = new PhotoCellController(this);
    }

    private void setImageRatio(ImageView imageView) {
        imageView.fitWidthProperty().bind(widthProperty());
        imageView.fitHeightProperty().bind(heightProperty());
        imageView.setPreserveRatio(true);
    }

    public Image getImage() {
        return imageView.getImage();
    }

    public void setImage(Image image) {
        imageView.setImage(image);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
