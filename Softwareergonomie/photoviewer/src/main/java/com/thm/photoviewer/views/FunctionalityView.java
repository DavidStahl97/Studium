package com.thm.photoviewer.views;

import com.thm.photoviewer.controller.FunctionalityController;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class FunctionalityView extends BorderPane {

    private HBox hBox;

    private Button leftButton;
    private Button rightButton;

    public FunctionalityView() {
        hBox = new HBox();
        super.setCenter(hBox);

        leftButton = new Button();
        leftButton.setText("L");

        rightButton = new Button();
        rightButton.setText("R");

        hBox.getChildren().addAll(leftButton, rightButton);
    }

    public Button getLeftButton() {
        return leftButton;
    }

    public Button getRightButton() {
        return rightButton;
    }

}
