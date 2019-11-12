package com.thm.photoviewer.topbar;

import com.thm.common.ImageChooser;
import com.thm.common.PhotoLoader;
import com.thm.photoviewer.BaseController;
import com.thm.photoviewer.slideshow.SlideshowWindow;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.models.Zooming;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TopBarController extends BaseController<TopBar> {

    private ImageChooser imageChooser = new ImageChooser();
    private PhotoList photoList;

    public TopBarController(TopBar view, PhotoList photoList, Zooming zooming) {
        super(view);
        this.photoList = photoList;

        photoList.sizeProperty().addListener((observableValue, oldSize, newSize) -> {
            boolean noPhotos = photoList.size() == 0;
            view.getRemoveButton().setDisable(noPhotos);
            view.getDialogButton().setDisable(noPhotos);
            view.getZoomBox().setVisible(!noPhotos);
        });

        view.getZoomSlider().valueProperty().addListener((observableValue, number, value) -> {
            double d = value.doubleValue();
            var s = String.format("%.2f", d);
            view.getZoomLabel().setText(s);
        });
        view.getZoomLabel().setText("1.00");

        view.getZoomSlider().valueProperty().bindBidirectional(zooming.zoomValueProperty());

        view.getAddButton().setOnAction(event -> onAddPhoto());
        view.getRemoveButton().setOnAction(event -> onRemovePhoto());
        view.getDialogButton().setOnAction(event -> onStartSlideshow());
    }

    private void onAddPhoto() {
        var window = super.getStage();
        try {
            var files = imageChooser.show(window);
            if(files.size() == 0) {
                return;
            }

            var loader = new PhotoLoader();
            loader.photoProperty().addListener((observable, oldValue, newValue) -> {
                photoList.addAll(newValue);
                if(photoList.getSelectedPhoto() == null) {
                    photoList.setSelectedPhoto(newValue);
                }
            });
            loader.finishedProperty().addListener((observable, oldValue, finished) -> {
                if(finished) {
                    view.getChildren().remove(view.getProgressIndicator());
                    view.add(view.getDialogButton(), 3,0);
                }
            });

            view.getChildren().remove(view.getDialogButton());
            view.add(view.getProgressIndicator(), 3, 0);

            loader.start(files);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onRemovePhoto() {
        var left = photoList.getNextPhoto(Direction.LEFT);
        var right = photoList.getNextPhoto(Direction.RIGHT);
        var centerIndex = photoList.indexOf(photoList.getSelectedPhoto());
        photoList.removeSelectedPhoto();
        if(photoList.size() > 0) {
            if(Math.abs(centerIndex - photoList.indexOf(left)) < Math.abs(centerIndex - photoList.indexOf(right))) {
                photoList.setSelectedPhoto(left);
            }
            else {
                photoList.setSelectedPhoto(right);
            }
        }
        else {
            photoList.setSelectedPhoto(null);
        }
    }

    private void onStartSlideshow() {
        var slideshow = new SlideshowWindow();
        slideshow.show();
    }
}
