package com.thm.photoviewer;

import javafx.scene.layout.Pane;

public class ControllerBase<T extends Pane> {

    protected T view;

    public ControllerBase(Class<T> clazz) {
        var factory = new GenericCreateFactory<T>(clazz);
        view = factory.createInstance();
    }

    public Pane getParentPane() {
        return view;
    }

}
