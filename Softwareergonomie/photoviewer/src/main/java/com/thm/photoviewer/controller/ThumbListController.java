package com.thm.photoviewer.controller;

import com.thm.eventbus.IEventAggregator;
import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.ImageChooser;
import com.thm.photoviewer.events.SelectThumbEvent;
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

    private IEventAggregator eventAggregator;
    private ImageChooser imageChooser;

    private ObservableList<Photo> thumbs;
    private Photo selectedPhoto;

    public ThumbListController(IEventAggregator eventAggregator) {
        super(ThumbListView.class);
        this.eventAggregator = eventAggregator;
        imageChooser = new ImageChooser();

        thumbs = FXCollections.observableArrayList();
        view.getThumbsListView().setItems(thumbs);
        view.getThumbsListView().getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectThumbEvent(newValue)
        );

        view.getAddButton().setOnAction(e -> addEvent());
        view.getDeleteButton().setOnAction(e -> deleteEvent());
    }

    private void selectThumbEvent(Photo newValue) {
        selectedPhoto = newValue;
        eventAggregator.getEvent(SelectThumbEvent.class).publish(selectedPhoto);
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
