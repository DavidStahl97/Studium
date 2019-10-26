package com.thm.photoviewer.controller;

import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.ImageChooser;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.views.ThumbListView;

import java.io.FileNotFoundException;

public class ThumbListController extends ControllerBase<ThumbListView> {

    private ImageChooser imageChooser;

    private PhotoList photoList;
    private Photo selectedPhoto;

    public ThumbListController(PhotoList photoList) {
        super(ThumbListView.class);

        this.photoList = photoList;

        imageChooser = new ImageChooser();

        photoList.selectedPhotoProperty().addListener(
                (observable, oldValue, newValue) -> view.getThumbsListView().getSelectionModel().select(newValue)
        );

        view.getThumbsListView().setItems(photoList);
        view.getThumbsListView().getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> photoList.setSelectedPhoto(newValue)
        );

        view.getAddButton().setOnAction(e -> onAddPhoto());
        view.getDeleteButton().setOnAction(e -> onDeletePhoto());
    }

    private void onDeletePhoto() {
        photoList.removeSelectedPhoto();
    }

    private void onAddPhoto() {
        var window = view.getScene().getWindow();
        try {
            var photo = imageChooser.show(window);
            photoList.addAll(photo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
