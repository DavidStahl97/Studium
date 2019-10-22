package com.thm.photoviewer.views;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ThumbListView extends Pane {

    private ScrollPane scrollPane;
    private VBox vBox;

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
    }

}
