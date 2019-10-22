package com.thm.photoviewer.controller;

import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.views.ShellView;

public class ShellController extends ControllerBase<ShellView> {

    private ThumbListController thumbListController;

    public ShellController() {
        super(ShellView.class);

        thumbListController = new ThumbListController();
        view.setLeft(thumbListController.getParentPane());
    }

}
