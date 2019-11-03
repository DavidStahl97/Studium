package com.thm.photoviewer.topbar;

import com.thm.common.ImageChooser;
import com.thm.photoviewer.BaseController;
import com.thm.photoviewer.slideshow.SlideshowWindow;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.models.Zooming;

import java.io.FileNotFoundException;

public class TopBarController extends BaseController<TopBar> {

    private ImageChooser imageChooser = new ImageChooser();
    private PhotoList photoList;

    public TopBarController(TopBar view) {
        super(view);

        photoList = PhotoList.getPhotoList();

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

        var zooming = Zooming.getInstance();
        view.getZoomSlider().valueProperty().bindBidirectional(zooming.zoomValueProperty());

        view.getAddButton().setOnAction(event -> onAddPhoto());
        view.getRemoveButton().setOnAction(event -> onRemovePhoto());
        view.getDialogButton().setOnAction(event -> onStartDiashow());
    }

    private void onAddPhoto() {
        var window = super.getStage();
        try {
            var photos = imageChooser.show(window);
            photoList.addAll(photos);

            if(photos.size() > 0 && photoList.getSelectedPhoto() == null) {
                photoList.setSelectedPhoto(photos.get(0));
            }
        } catch (FileNotFoundException e) {
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

    private void onStartDiashow() {
        var diashow = new SlideshowWindow();
        diashow.show();
    }
}
