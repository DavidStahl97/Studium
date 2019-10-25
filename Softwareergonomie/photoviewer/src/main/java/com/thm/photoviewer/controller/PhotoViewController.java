package com.thm.photoviewer.controller;

import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.models.Direction;
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

        photoList.selectedPhotoProperty().addListener((observable, oldValue, newValue) -> onSelectedPhoto(newValue));

        view.getFirstImageView().setOnMousePressed(e -> clickSceneX = e.getSceneX());
        view.getFirstImageView().setOnMouseReleased(e -> onMouseReleased(e));



    }

    private void onMouseReleased(MouseEvent e) {
        double releasedMouseX = e.getSceneX();
        //var direction = clickSceneX > releasedMouseX ? Direction.RIGHT : Direction.LEFT;
        //photoList.nextPhoto(direction);
    }

    private void onSelectedPhoto(Photo p) {
        if(p == null) {
            view.getFirstImageView().setImage(null);
            return;
        }

        var first = view.getFirstImageView();
        var second = view.getSecondImageView();
        var third = view.getThirdImageView();

        second.setTranslateX(- view.getWidth() - 10);
        third.setTranslateX(view.getWidth() + 10);

        first.setImage(p.getImage());
        second.setImage(photoList.getNextPhoto(Direction.LEFT).getImage());
        third.setImage(photoList.getNextPhoto(Direction.RIGHT).getImage());
    }
}
