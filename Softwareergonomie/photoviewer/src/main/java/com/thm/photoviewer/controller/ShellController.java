package com.thm.photoviewer.controller;

import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.views.ShellView;

public class ShellController extends ControllerBase<ShellView> {

    private ThumbListController thumbListController;
    private PhotoViewController photoViewController;

    public ShellController(ThumbListController thumbListController, PhotoViewController photoViewController) {
        super(ShellView.class);

        // ToDo: view should do it
        this.thumbListController = thumbListController;
        view.setLeft(thumbListController.getParentPane());

        this.photoViewController = photoViewController;
        view.setCenter(photoViewController.getParentPane());
    }

}
