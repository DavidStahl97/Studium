package com.thm.photoviewer.controller;

import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.views.ThumbListView;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ThumbListController extends ControllerBase<ThumbListView> {

    private PhotoList photoList;

    public ThumbListController(PhotoList photoList) {
        super(ThumbListView.class);

        this.photoList = photoList;
        photoList.addListener((ListChangeListener<? super Photo>) c -> photoListChanged(c));
    }

    private void photoListChanged(ListChangeListener.Change<? extends Photo> c) {

    }

}
