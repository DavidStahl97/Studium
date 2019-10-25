package com.thm.photoviewer.views;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PhotoView extends Pane {

    private Pane imagePane;

    private ImageView firstImageView;
    private ImageView secondImageView;
    private ImageView thirdImageView;

    double orgSceneX;
    double orgTranslateX, orgTranslateXSecond, orgTranslateXThird;

    public PhotoView() {

        imagePane = new Pane();
        imagePane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        clipChildren(imagePane, 3 * 4);
        super.getChildren().add(imagePane);

        firstImageView = createImageView();
        secondImageView = createImageView();
        thirdImageView = createImageView();
        imagePane.getChildren().addAll(firstImageView, secondImageView, thirdImageView);
    }

    public ImageView getFirstImageView() {
        return firstImageView;
    }

    public ImageView getSecondImageView() {
        return secondImageView;
    }

    public ImageView getThirdImageView() {
        return thirdImageView;
    }

    private ImageView createImageView() {
        var imageView = new ImageView();
        imageView.fitWidthProperty().bind(super.widthProperty());
        imageView.fitHeightProperty().bind(super.heightProperty());

        imageView.setCursor(Cursor.HAND);
        imageView.addEventFilter(MouseEvent.MOUSE_PRESSED, t -> {
            orgSceneX = t.getSceneX();
            orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();

            orgTranslateXSecond = secondImageView.getTranslateX();

            orgTranslateXThird = thirdImageView.getTranslateX();

        });
        imageView.setOnMouseDragged(t -> {
            double offsetX = t.getSceneX() - orgSceneX;
            orgSceneX = t.getSceneX();

            if((secondImageView.getTranslateX() > -10 && offsetX > 0)
                    || (thirdImageView.getTranslateX() < 10 && offsetX < 0)) {
                return;
            }

            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateXSecond = orgTranslateXSecond + offsetX;
            double newTranslateXThird = orgTranslateXThird + offsetX;

            secondImageView.setTranslateX(newTranslateXSecond);
            thirdImageView.setTranslateX(newTranslateXThird);

            ((ImageView)(t.getSource())).setTranslateX(newTranslateX);

            orgTranslateX = newTranslateX;
            orgTranslateXSecond = newTranslateXSecond;
            orgTranslateXThird =  newTranslateXThird;
        });

        return imageView;
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
