package com.thm.photoviewer.controller;

import com.thm.eventbus.IEventAggregator;
import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.events.ToLeftEvent;
import com.thm.photoviewer.events.ToRightEvent;
import com.thm.photoviewer.views.FunctionalityView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

public class FunctionalityController extends ControllerBase<FunctionalityView> {

    private IEventAggregator eventAggregator;

    private KeyCombination rightKeyPressed;
    private KeyCombination leftKeyPressed;

    public FunctionalityController(IEventAggregator eventAggregator) {
        super(FunctionalityView.class);

        this.eventAggregator = eventAggregator;

        view.getLeftButton().setOnAction(e -> leftEvent());
        view.getRightButton().setOnAction(e -> rightEvent());

        leftKeyPressed = new KeyCodeCombination(KeyCode.BRACELEFT, KeyCodeCombination.CONTROL_DOWN);
        rightKeyPressed = new KeyCodeCombination(KeyCode.BRACERIGHT, KeyCodeCombination.CONTROL_DOWN);

        view.sceneProperty().addListener(e -> OnViewInitialized());
    }

    private void OnViewInitialized() {
        view.setOnKeyPressed(e -> keyboardPressed(e));
    }

    private void keyboardPressed(KeyEvent e) {
        if(leftKeyPressed.match(e)) {
            leftEvent();
        }
        else if(rightKeyPressed.match(e)) {
            rightEvent();
        }
    }

    private void rightEvent() {
        eventAggregator.getEvent(ToLeftEvent.class).publish(null);
    }

    private void leftEvent() {
        eventAggregator.getEvent(ToRightEvent.class).publish(null);
    }

}
