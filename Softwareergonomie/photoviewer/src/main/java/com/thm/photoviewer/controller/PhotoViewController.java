package com.thm.photoviewer.controller;

import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.views.PhotoView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PhotoViewController extends ControllerBase<PhotoView> {

    private ImageView imageView;

    public PhotoViewController() {
        super(PhotoView.class);

        imageView = view.getImageView();
        imageView.fitWidthProperty().bind(view.widthProperty());
        imageView.fitHeightProperty().bind(view.heightProperty());
    }

    private void setImageRatio(ImageView imageView) {
        var image = imageView.getImage();
        if(image.getWidth() > image.getHeight()) {
            imageView.fitWidthProperty().bind(view.widthProperty());
            imageView.fitHeightProperty().unbind();
        }
        else {
            imageView.fitHeightProperty().bind(view.heightProperty());
            imageView.fitWidthProperty().unbind();
        }

        imageView.setPreserveRatio(true);
    }

    public void setImage(Image image) {
        imageView.setImage(image);
    }

    public Image getImage() {
        return imageView.getImage();
    }

}
