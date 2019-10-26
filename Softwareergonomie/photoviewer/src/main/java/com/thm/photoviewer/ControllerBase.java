package com.thm.photoviewer;

import com.thm.GenericCreateFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class ControllerBase<T extends Pane> {

    protected T view;

    public ControllerBase(Class<T> clazz) {
        var factory = new GenericCreateFactory<T>(clazz);
        view = factory.createInstance();
    }

    public T getParentPane() {
        return view;
    }

    public Scene getScene() {
        return view.getScene();
    }

}
