package com.thm.photoviewer.views;

import com.thm.photoviewer.models.Photo;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ThumbListView extends Pane {

    private ScrollPane scrollPane;
    private HBox thumbBox;

    public ThumbListView() {
        thumbBox = new HBox();
        scrollPane = new ScrollPane(thumbBox);

        super.getChildren().add(scrollPane);
    }

    public Pane getThumbBox() {
        return thumbBox;
    }
}
