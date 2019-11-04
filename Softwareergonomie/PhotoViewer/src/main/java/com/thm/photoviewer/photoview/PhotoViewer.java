package com.thm.photoviewer.photoview;

import com.thm.common.InjectionService;
import com.thm.common.ModuloArray;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.kordamp.ikonli.javafx.FontIcon;

public class PhotoViewer extends GridPane {
    private static final int PHOTO_VIEW_COUNT = 3;

    private PhotoViewController controller;

    private Button leftButton;
    private Button rightButton;

    private ModuloArray<PhotoCell> photoCells;

    public PhotoViewer() {
        // columns constraints
        var resizable = new ColumnConstraints();
        resizable.setHgrow(Priority.ALWAYS);
        var nonResizable = new ColumnConstraints();
        nonResizable.setHgrow(Priority.NEVER);
        super.getColumnConstraints().addAll(nonResizable, resizable, nonResizable);

        // children
        // buttons
        leftButton = new Button();
        leftButton.setGraphic(new FontIcon("dashicons-arrow-left-alt2"));
        leftButton.setAlignment(Pos.CENTER_LEFT);
        leftButton.setStyle("-fx-background-color: #ffffff;");
        super.add(leftButton, 0,0);

        rightButton = new Button();
        rightButton.setGraphic(new FontIcon("dashicons-arrow-right-alt2"));
        rightButton.setAlignment(Pos.CENTER_RIGHT);
        rightButton.setStyle("-fx-background-color: #ffffff;");
        super.add(rightButton, 2,0);

        createPhotoCells();

        controller = InjectionService.getInstance().getInstance(PhotoViewController.class, this);
    }

    private void createPhotoCells() {
        photoCells = new ModuloArray<>();

        for(int i = 0; i < PHOTO_VIEW_COUNT; i++) {
            var photoCell = new PhotoCell();
            photoCells.add(photoCell);

            super.add(photoCell, 0,0, 3,1);
            photoCell.toBack();
            photoCell.prefWidthProperty().bind(super.widthProperty());
            photoCell.prefHeightProperty().bind(super.heightProperty());
        }
    }

    public Button getLeftButton() {
        return leftButton;
    }

    public Button getRightButton() {
        return rightButton;
    }

    public ModuloArray<PhotoCell> getPhotoCells() {
        return photoCells;
    }

}
