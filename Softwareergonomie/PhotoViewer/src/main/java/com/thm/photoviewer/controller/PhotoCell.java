package com.thm.photoviewer.controller;

import com.thm.photoviewer.App;
import com.thm.photoviewer.models.Photo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PhotoCell extends Pane implements Initializable {

    private Photo photo;

    @FXML
    private ImageView imageView;

    public PhotoCell() {
        var url = App.class.getResource("photo_cell" + ".fxml");
        var fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
            double width = getHeight() * imageRatio;
            double x = (getWidth() - width) / 2;
            imageView.setTranslateX(x);
            imageView.setTranslateY(0);
        }
        else if(imageRatio > viewRatio) {
            double height = getWidth() / imageRatio;
            double y = (getHeight() - height) / 2;
            imageView.setTranslateY(y);
            imageView.setTranslateX(0);
        }
        else {
            imageView.setTranslateX(0);
            imageView.setTranslateY(0);
        }
    }

    private void setImageRatio(ImageView imageView) {
        imageView.fitWidthProperty().bind(widthProperty());
        imageView.fitHeightProperty().bind(heightProperty());
        imageView.setPreserveRatio(true);
    }

    public Image getImage() {
        return imageView.getImage();
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        imageView.setImage(photo.getImage());
        calculatePosition();
    }

    public Photo getPhoto() {
        return photo;
    }
}
