package com.thm.photoviewer.topbar;

import com.thm.common.InjectionService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import org.kordamp.ikonli.javafx.FontIcon;

public class TopBar extends GridPane {

    private TopBarController controller;

    private Button addButton;
    private Button removeButton;
    private Button dialogButton;

    private ProgressIndicator progressIndicator;

    private HBox zoomBox;
    private Slider zoomSlider;
    private Label zoomLabel;

    public TopBar() {
        // style
        super.setStyle("-fx-background-color: #BCBEC0");

        // padding
        super.setPadding(new Insets(5));

        // columns constraints
        var resizable = new ColumnConstraints();
        resizable.setHgrow(Priority.ALWAYS);
        var nonResizable = new ColumnConstraints();
        nonResizable.setHgrow(Priority.NEVER);
        super.getColumnConstraints().addAll(nonResizable, nonResizable, resizable, nonResizable);

        // children
        addButton = new Button();
        addButton.setGraphic(new FontIcon("dashicons-plus"));
        super.add(addButton, 0, 0);

        removeButton = new Button();
        removeButton.setGraphic(new FontIcon("dashicons-minus"));
        super.add(removeButton, 1, 0);

        zoomSlider = new Slider();
        zoomSlider.setMin(1);
        zoomSlider.setMax(10);
        zoomLabel = new Label();

        zoomBox = new HBox();
        zoomBox.setAlignment(Pos.CENTER);
        zoomBox.getChildren().addAll(zoomSlider, zoomLabel);
        super.add(zoomBox, 2, 0);

        dialogButton = new Button();
        dialogButton.setGraphic(new FontIcon("dashicons-controls-play"));
        super.add(dialogButton, 3, 0);

        progressIndicator = new ProgressIndicator();
        progressIndicator.setMaxWidth(25);
        progressIndicator.setMaxHeight(25);

        // controller
        controller = InjectionService.getInstance().getInstance(TopBarController.class, this);
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public Button getDialogButton() {
        return dialogButton;
    }

    public HBox getZoomBox() {
        return zoomBox;
    }

    public Label getZoomLabel() {
        return zoomLabel;
    }

    public Slider getZoomSlider() {
        return zoomSlider;
    }

    public ProgressIndicator getProgressIndicator() {
        return progressIndicator;
    }
}
