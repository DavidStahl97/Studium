package com.thm.photoviewer.controller;

import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.views.ImageViewList;
import com.thm.photoviewer.views.PhotoView;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

public class PhotoViewController extends ControllerBase<PhotoView> {

    private ImageViewList imageViewList;
    private PhotoList photoList;

    double orgSceneX;

    public PhotoViewController(PhotoList photoList) {
        super(PhotoView.class);

        this.imageViewList = new ImageViewList();
        view.getChildren().addAll(imageViewList.getImageViews());
        clipChildren(view, 12);
        for(var imageView : imageViewList.getImageViews()) {
            configureImageView(imageView);
        }

        this.photoList = photoList;
        photoList.selectedPhotoProperty().addListener((observable, oldValue, newValue) -> onSelectedPhoto(newValue));
    }

    private void onMouseReleased(MouseEvent e) {
        double releasedMouseX = e.getSceneX();
        //var direction = clickSceneX > releasedMouseX ? Direction.RIGHT : Direction.LEFT;
        //photoList.nextPhoto(direction);
    }

    private void onSelectedPhoto(Photo p) {
        if(p == null) {
            imageViewList.deleteImages();
            return;
        }

        var center = imageViewList.getCenterImageView();
        var left = imageViewList.getLeftImageView();
        var right = imageViewList.getRightImageView();

        left.setTranslateX(- view.getWidth() - 10);
        right.setTranslateX(view.getWidth() + 10);

        center.setImage(p.getImage());
        left.setImage(photoList.getNextPhoto(Direction.LEFT).getImage());
        right.setImage(photoList.getNextPhoto(Direction.RIGHT).getImage());
    }

    private void configureImageView(ImageView imageView) {
        imageView.fitWidthProperty().bind(super.view.widthProperty());
        imageView.fitHeightProperty().bind(super.view.heightProperty());

        imageView.setCursor(Cursor.HAND);

        imageView.addEventFilter(MouseEvent.MOUSE_PRESSED, t -> {
            orgSceneX = t.getSceneX();
            imageViewList.snapshotingXPosition();
        });

        imageView.setOnMouseDragged(t -> {
            double offsetX = t.getSceneX() - orgSceneX;
            orgSceneX = t.getSceneX();

            var left = imageViewList.getLeftImageView();
            var right = imageViewList.getRightImageView();
            if((left.getTranslateX() > -10 && offsetX > 0)
                    || (right.getTranslateX() < 10 && offsetX < 0)) {
                return;
            }

            imageViewList.moveXPositions(offsetX);
        });
    }

    private void clipChildren(Region region, double arc) {
        final Rectangle outputClip = new Rectangle();
        outputClip.setArcWidth(arc);
        outputClip.setArcHeight(arc);
        region.setClip(outputClip);

        region.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }
}
