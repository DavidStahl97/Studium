package com.thm.photoviewer.controller;

import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.ImageChooser;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.views.ThumbListView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.FileNotFoundException;

public class ThumbListController extends ControllerBase<ThumbListView> {

    private ImageChooser imageChooser;

    private ObservableList<Photo> thumbs;
    private Photo selectedPhoto;

    public ThumbListController() {
        super(ThumbListView.class);

        imageChooser = new ImageChooser();

        thumbs = FXCollections.observableArrayList();
        view.getThumbsListView().setItems(thumbs);
        view.getThumbsListView().getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectedPhoto = newValue
        );

        view.getAddButton().setOnAction(e -> addEvent());
        view.getDeleteButton().setOnAction(e -> deleteEvent());
    }

    private void deleteEvent() {
        thumbs.remove(selectedPhoto);
    }

    private void addEvent() {
        var window = view.getScene().getWindow();
        try {
            var photo = imageChooser.show(window);
            thumbs.addAll(photo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
