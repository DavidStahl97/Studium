package com.thm.photoviewer;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class BaseController<T extends Pane> {

    protected T view;

    public BaseController(T view) {
        this.view = view;
        listeningInitialization();
    }

    protected Stage getStage() {
        return (Stage) view.getScene().getWindow();
    }

    protected void initialized() {}

    private void listeningInitialization() {
        view.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
            if (oldScene == null && newScene != null) {
                // scene is set for the first time. Now its the time to listen stage changes.
                newScene.windowProperty().addListener((observableWindow, oldWindow, newWindow) -> {
                    if (oldWindow == null && newWindow != null) {
                        // stage is set. now is the right time to do whatever we need to the stage in the controller.
                        initialized();
                    }
                });
            }
        });
    }
}
