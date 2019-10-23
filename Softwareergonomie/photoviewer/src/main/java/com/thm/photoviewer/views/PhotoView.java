package com.thm.photoviewer.views;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class PhotoView extends Pane {

    private HBox hBox;
    private ImageView imageView;

    private Button leftButton;
    private Button rightButton;

    public PhotoView() {
        hBox = new HBox();
        super.getChildren().add(hBox);

        imageView = new ImageView();
        imageView.fitWidthProperty().bind(super.widthProperty());
        imageView.fitHeightProperty().bind(super.heightProperty());

        leftButton = new Button();
        leftButton.setText("<");

        rightButton = new Button();
        rightButton.setText(">");

        hBox.getChildren().addAll(imageView);
    }

    public ImageView getImageView() {
        return imageView;
    }

}
