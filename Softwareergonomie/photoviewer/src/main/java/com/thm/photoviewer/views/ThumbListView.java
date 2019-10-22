package com.thm.photoviewer.views;

import com.thm.photoviewer.models.Photo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ThumbListView extends Pane {

    private ScrollPane scrollPane;
    private VBox vBox;

    private ListView<Photo> thumbList;

    private HBox buttonBox;
    private Button addButton;
    private Button deleteButton;

    public ThumbListView() {
        scrollPane = new ScrollPane();
        super.getChildren().add(scrollPane);

        vBox = new VBox();
        scrollPane.setContent(vBox);

        buttonBox = new HBox();

        addButton = new Button();
        addButton.setText("Add");

        deleteButton = new Button();
        deleteButton.setText("Delete");

        buttonBox.getChildren().addAll(addButton, deleteButton);
        vBox.getChildren().add(buttonBox);

        thumbList = new ListView<>();
        thumbList.setCellFactory(p -> new ThumbsListCell());
        vBox.getChildren().add(thumbList);
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public ListView<Photo> getThumbsListView() {
        return thumbList;
    }
}
