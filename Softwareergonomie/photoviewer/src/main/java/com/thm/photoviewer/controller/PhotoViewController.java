package com.thm.photoviewer.controller;

import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.views.PhotoView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PhotoViewController extends ControllerBase<PhotoView> {

    private ImageView imageView;
    private Photo photo;

    public PhotoViewController() {
        super(PhotoView.class);

        imageView = view.getImageView();
        imageView.fitWidthProperty().addListener((observable, oldValue, newValue) -> calculatePosition());
        imageView.fitHeightProperty().addListener((observable, oldValue, newValue) -> calculatePosition());
        setImageRatio(imageView);
    }

    private void calculatePosition() {
        if(imageView.getImage() == null || imageView.getFitHeight() == 0) {
            return;
        }

        var image = imageView.getImage();
        double imageRatio = image.getWidth() / image.getHeight();
        double viewRatio = imageView.getFitWidth() / imageView.getFitHeight();

        if(imageRatio < viewRatio) {
            double width = view.getHeight() * imageRatio;
            double x = (view.getWidth() - width) / 2;
            imageView.setTranslateX(x);
            imageView.setTranslateY(0);
        }
        else if(imageRatio > viewRatio) {
            double height = view.getWidth() / imageRatio;
            double y = (view.getHeight() - height) / 2;
            imageView.setTranslateY(y);
            imageView.setTranslateX(0);
        }
        else {
            imageView.setTranslateX(0);
            imageView.setTranslateY(0);
        }
    }

    private void setImageRatio(ImageView imageView) {
        imageView.fitWidthProperty().bind(view.widthProperty());
        imageView.fitHeightProperty().bind(view.heightProperty());
        imageView.setPreserveRatio(true);
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        imageView.setImage(photo.getImage());
        calculatePosition();
    }

    public Photo getPhoto() {
        return photo;
    }

    public Image getImage() {
        return imageView.getImage();
    }

}
