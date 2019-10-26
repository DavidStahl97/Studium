package com.thm.photoviewer.controller;

import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.views.ShellView;

public class ShellController extends ControllerBase<ShellView> {

    private ThumbListController thumbListController;
    private ShowPhotosController showPhotosController;

    public ShellController(ThumbListController thumbListController, ShowPhotosController showPhotosController) {
        super(ShellView.class);

        this.thumbListController = thumbListController;
        view.setLeft(thumbListController.getParentPane());

        this.showPhotosController = showPhotosController;
        view.setCenter(showPhotosController.getParentPane());

    }

}
