package com.thm.photoviewer.views;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class BottomView extends HBox {

    private VBox buttons;
    private Button addButton;
    private Button deleteButton;

    private Pane thumbPane;

    public BottomView() {
        buttons = new VBox();

        addButton = new Button();
        addButton.setText("Add");

        deleteButton = new Button();
        deleteButton.setText("Delete");

        buttons.getChildren().addAll(addButton, deleteButton);

        thumbPane = new Pane();

        super.getChildren().addAll(buttons, thumbPane);
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Pane getThumbPane() {
        return thumbPane;
    }

}
