package com.thm.photoviewer.controller;

import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.views.ShellView;

public class ShellController extends ControllerBase<ShellView> {

    //private ThumbListController thumbListController;
    private ShowPhotosController showPhotosController;
    private BottomController bottomController;

    public ShellController(BottomController bottomController, ShowPhotosController showPhotosController) {
        super(ShellView.class);

        //this.thumbListController = thumbListController;
        //view.setBottom(thumbListController.getParentPane());
        this.bottomController = bottomController;
        view.setBottom(bottomController.getParentPane());

        this.showPhotosController = showPhotosController;
        view.setCenter(showPhotosController.getParentPane());

    }

}
