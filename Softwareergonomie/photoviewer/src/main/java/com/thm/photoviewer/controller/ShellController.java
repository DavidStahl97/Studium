package com.thm.photoviewer.controller;

import com.thm.photoviewer.views.ShellView;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ShellController {

    private ShellView shellView;

    private ThumbListController thumbListController;

    public ShellController() {
        shellView = new ShellView();
        
        thumbListController = new ThumbListController();
        shellView.setLeft(thumbListController.getPane());
    }

    public Pane getParentPane() {
        return shellView;
    }

}
