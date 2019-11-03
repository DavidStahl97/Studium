package com.thm.photoviewer.slideshow;

import com.thm.photoviewer.photoview.PhotoCell;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import org.kordamp.ikonli.javafx.FontIcon;

public class Slideshow extends StackPane {

    private SlideshowController controller;

    private PhotoCell photoCellOne;
    private PhotoCell photoCellTwo;

    private GridPane functionalityGrid;
    private Button expandButton;
    private Slider slider;

    public Slideshow() {
        // style
        super.setStyle("-fx-background-color: #000;");

        //children
        //photo cells
        photoCellOne = new PhotoCell();
        photoCellOne.setOpacity(1);

        photoCellTwo = new PhotoCell();
        photoCellTwo.setOpacity(0);

        // functionality grid
        functionalityGrid = new GridPane();

        // columns constraints
        var columnResizable = new ColumnConstraints();
        columnResizable.setHgrow(Priority.ALWAYS);
        var columnNonResizable = new ColumnConstraints();
        columnNonResizable.setHgrow(Priority.NEVER);
        functionalityGrid.getColumnConstraints().addAll(columnNonResizable, columnResizable, columnNonResizable);

        // row constraints
        var rowResizable = new RowConstraints();
        rowResizable.setVgrow(Priority.ALWAYS);
        var nonRowResizable = new RowConstraints();
        nonRowResizable.setVgrow(Priority.NEVER);
        functionalityGrid.getRowConstraints().addAll(nonRowResizable, rowResizable, nonRowResizable);

        // buttons
        expandButton = new Button();
        expandButton.setGraphic(new FontIcon("dashicons-editor-expand"));
        functionalityGrid.add(expandButton, 2,0);

        // slider
        var gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        functionalityGrid.add(gridPane, 1,2);

        slider = new Slider();
        slider.setOrientation(Orientation.HORIZONTAL);
        slider.setMaxWidth(150);
        gridPane.add(slider,0,0);

        // add children
        super.getChildren().addAll(photoCellOne, photoCellTwo, functionalityGrid);

        controller = new SlideshowController(this);
    }

    public PhotoCell getPhotoCellOne() {
        return photoCellOne;
    }

    public PhotoCell getPhotoCellTwo() {
        return photoCellTwo;
    }

    public Button getExpandButton() {
        return expandButton;
    }

    public Slider getSlider() {
        return slider;
    }
}
