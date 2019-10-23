package com.thm.photoviewer.controller;

import com.thm.eventbus.IEventAggregator;
import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.events.SelectThumbEvent;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.views.PhotoView;
import javafx.scene.input.MouseEvent;

public class PhotoViewController extends ControllerBase<PhotoView> {

    private double clickSceneX;

    private PhotoList photoList;

    public PhotoViewController(PhotoList photoList) {
        super(PhotoView.class);

        this.photoList = photoList;

        photoList.selectedPhotoProperty().addListener((observable, oldValue, newValue) -> selectPhotoEvent(newValue));

        view.getImageView().setOnMousePressed(e -> clickSceneX = e.getSceneX());
        view.getImageView().setOnMouseReleased(e -> onMouseReleased(e));
    }

    private void onMouseReleased(MouseEvent e) {
        double releasedMouseX = e.getSceneX();

    }

    private void selectPhotoEvent(Photo p) {
        if(p == null) {
            view.getImageView().setImage(null);
            return;
        }

        view.getImageView().setImage(p.getImage());
    }
}
