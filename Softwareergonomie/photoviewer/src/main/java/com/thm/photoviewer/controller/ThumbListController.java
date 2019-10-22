package com.thm.photoviewer.controller;

import com.thm.photoviewer.views.ThumbListView;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ThumbListController {

    private ThumbListView thumbListView;

    public ThumbListController() {
        this.thumbListView = new ThumbListView();
    }

    public Pane getPane() {
        return thumbListView;
    }
}
