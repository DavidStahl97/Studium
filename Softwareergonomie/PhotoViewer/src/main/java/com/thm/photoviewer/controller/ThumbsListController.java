package com.thm.photoviewer.controller;

import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.models.PhotoList;
import javafx.animation.TranslateTransition;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ThumbsListController implements Initializable {

    private static final double OPACITY = 0.5;

    private PhotoList photoList;

    @FXML
    private HBox thumbsBox;

    @FXML
    private Pane pane;

    @FXML
    private Button leftButton;

    @FXML
    private Button rightButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        photoList = PhotoList.getPhotoList();
        photoList.addListener((ListChangeListener<? super Photo>) c -> photoListChanged(c));
        photoList.selectedPhotoProperty().addListener((observable, oldValue, newValue) -> onSelectedPhotoChanged(newValue));

        clipChildren(pane, 12);

        pane.widthProperty().addListener((observable, oldValue, newValue) -> alignThumbBox(newValue.doubleValue()));
        thumbsBox.widthProperty().addListener((observable, oldValue, newValue) -> alignThumbBox(pane.getWidth()));

        rightButton.setOnMouseClicked(event -> onRightButtonClicked());
        leftButton.setOnMouseClicked(event -> onLeftButtonClicked());
    }

    private void onLeftButtonClicked() {
        var paneWidth = pane.getWidth();
        var thumbsBoxX = thumbsBox.getTranslateX();

        if(Math.abs(thumbsBoxX) < paneWidth) {
            var transition = new TranslateTransition(Duration.seconds(0.3), thumbsBox);
            transition.setFromX(thumbsBox.getTranslateX());
            transition.setToX(0);
            transition.playFromStart();

            leftButton.setOpacity(0.0);
            rightButton.setOpacity(1.0);
        }
        else {
            var transition = new TranslateTransition(Duration.seconds(0.3), thumbsBox);
            transition.setFromX(thumbsBox.getTranslateX());
            transition.setToX(thumbsBox.getTranslateX() + pane.getWidth());
            transition.playFromStart();

            leftButton.setOpacity(1.0);
            rightButton.setOpacity(1.0);
        }
    }

    private void onRightButtonClicked() {
        var paneWidth = pane.getWidth();
        var thumbsBoxWidth = thumbsBox.getWidth();
        var thumbsBoxX = thumbsBox.getTranslateX();

        var difference = thumbsBoxWidth - (Math.abs(thumbsBoxX) + paneWidth);
        var transition = new TranslateTransition(Duration.seconds(0.3), thumbsBox);
        if(difference < paneWidth) {
            transition.setFromX(thumbsBox.getTranslateX());
            transition.setToX(thumbsBox.getTranslateX() - difference);
            transition.playFromStart();

            leftButton.setOpacity(1.0);
            rightButton.setOpacity(0.0);
        }
        else {
            transition.setFromX(thumbsBox.getTranslateX());
            transition.setToX(thumbsBox.getTranslateX() - pane.getWidth());
            transition.playFromStart();

            leftButton.setOpacity(1.0);
            rightButton.setOpacity(1.0);
        }
    }

    private void onSelectedPhotoChanged(Photo selectedPhoto) {
        if(selectedPhoto == null) {
            return;
        }

        var photoCell = thumbsBox.getChildren().stream()
                .filter(p -> ((Thumb) p).getPhoto().equals(selectedPhoto))
                .findAny()
                .get();

        var oldOptional = thumbsBox.getChildren().stream()
                .filter(p -> p.getOpacity() == OPACITY)
                .findAny();
        if(oldOptional.isPresent()) {
            oldOptional.get().setOpacity(1);
        }

        photoCell.setOpacity(OPACITY);
    }

    private void alignThumbBox(double newWidth) {
        var thumbWidth = thumbsBox.getWidth();
        if(thumbWidth < 1) {
            leftButton.setOpacity(0.0);
            rightButton.setOpacity(0.0);
            return;
        }

        if(thumbWidth < newWidth) {
            var offset = (newWidth - thumbWidth) / 2;
            thumbsBox.setTranslateX(offset);
            leftButton.setOpacity(0.0);
            rightButton.setOpacity(0.0);
        }
        else {
            thumbsBox.setTranslateX(0);
            leftButton.setOpacity(1.0);
            rightButton.setOpacity(1.0);
        }
    }


    private void photoListChanged(ListChangeListener.Change<? extends Photo> c) {
        while(c.next()) {
            for(var photo : c.getAddedSubList()) {
                var thumb = new Thumb();
                thumb.setPhoto(photo);
                thumbsBox.getChildren().add(thumb);
            }

            for(var photo : c.getRemoved()) {
                var thumb = thumbsBox.getChildren().stream()
                        .filter(t -> ((Thumb) t).getPhoto().equals(photo))
                        .findAny()
                        .get();

                thumbsBox.getChildren().remove(thumb);
            }
        }
    }

    private void clipChildren(Region region, double arc) {
        final Rectangle outputClip = new Rectangle();
        outputClip.setArcWidth(arc);
        outputClip.setArcHeight(arc);
        region.setClip(outputClip);

        region.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }
}
