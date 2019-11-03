package com.thm.photoviewer.photoview;

import com.thm.photoviewer.BaseController;

public class PhotoCellController extends BaseController<PhotoCell> {

    public PhotoCellController(PhotoCell view) {
        super(view);

        var imageView = view.getImageView();
        imageView.imageProperty().addListener((observable, oldValue, newValue) -> calculatePosition());
        imageView.fitWidthProperty().addListener((observable, oldValue, newValue) -> calculatePosition());
        imageView.fitHeightProperty().addListener((observable, oldValue, newValue) -> calculatePosition());
    }

    private void calculatePosition() {
        var imageView = view.getImageView();

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
}
