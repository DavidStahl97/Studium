package com.thm.photoviewer.thumbs;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.kordamp.ikonli.javafx.FontIcon;

public class ThumbList extends GridPane {

    private ThumbsListController controller;

    private HBox thumbsBox;

    private Button leftButton;
    private Button rightButton;

    public ThumbList() {
        // padding
        super.setPadding(new Insets(5,5,0,0));

        // children
        thumbsBox = new HBox();
        thumbsBox.setSpacing(10);
        super.getChildren().add(new Pane(thumbsBox));

        leftButton = new Button();
        leftButton.setGraphic(new FontIcon("dashicons-arrow-left-alt2"));
        super.add(leftButton, 0,0);

        rightButton = new Button();
        rightButton.setGraphic((new FontIcon("dashicons-arrow-right-alt2")));
        super.add(rightButton, 2, 0);

        // controller
        controller = new ThumbsListController(this);
    }

    public Button getLeftButton() {
        return leftButton;
    }

    public Button getRightButton() {
        return rightButton;
    }

    public HBox getThumbsBox() {
        return thumbsBox;
    }
}
