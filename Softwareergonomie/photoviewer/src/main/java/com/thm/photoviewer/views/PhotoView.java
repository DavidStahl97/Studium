package com.thm.photoviewer.views;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class PhotoView extends Pane {

    private ImageView[] imageViews = new ImageView[3];

    public PhotoView() {
        for(int i = 0; i < imageViews.length; i++) {
            imageViews[i] = new ImageView();
        }

        this.getChildren().addAll(imageViews);
    }

    public ImageView[] getImageViews() {
        return imageViews;
    }

}
