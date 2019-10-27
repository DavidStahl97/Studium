package com.thm.photoviewer.controller;

import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.ImageChooser;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.views.BottomView;

import java.io.FileNotFoundException;

public class BottomController extends ControllerBase<BottomView> {

    private ThumbListController thumbListController;

    private ImageChooser imageChooser;
    private PhotoList photoList;

    public BottomController(PhotoList photoList) {
        super(BottomView.class);

        this.imageChooser = new ImageChooser();
        this.photoList = photoList;
        this.thumbListController = new ThumbListController(photoList);

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
