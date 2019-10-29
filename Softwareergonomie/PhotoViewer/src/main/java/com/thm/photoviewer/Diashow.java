package com.thm.photoviewer;

import com.thm.common.ModuloArray;
import com.thm.photoviewer.models.PhotoList;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Diashow {

    private PhotoList photoList;

    private Stage stage;
    private Scene scene;
    private StackPane stackPane;

    private ModuloArray<ImageView> imageViews;

    public Diashow(PhotoList photoList) {
        this.photoList = photoList;

        stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: #000");

        imageViews = new ModuloArray<>();
        for(int i = 0; i < 2; i++) {
            var imageView = new ImageView();
            imageView.setOpacity(0);
            imageView.fitWidthProperty().bind(stackPane.widthProperty());
            imageView.fitHeightProperty().bind(stackPane.heightProperty());
            imageView.setPreserveRatio(true);

            var image = photoList.getPhoto(i).getImage();
            imageView.setImage(image);

            stackPane.getChildren().add(imageView);
            imageViews.add(imageView);
        }

        scene = new Scene(stackPane);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> onKeyPressed(event));

        stage = new Stage();
        stage.setScene(scene);
        stage.setFullScreen(true);
    }

    public void startDiashow() {
        stage.show();

        var first = imageViews.get(0);
        first.setOpacity(1);

        start(0);
    }

    private void start(final int currentIndex) {
        FadeTransition fadein = new FadeTransition(Duration.seconds(1), imageViews.get(currentIndex));

        fadein.setFromValue(0);
        fadein.setToValue(1);

        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        SequentialTransition st;
        st = new SequentialTransition(
                fadein, delay);

        st.setOnFinished(event -> {
            int i = currentIndex + 1;
            start(i);
        });

        st.playFromStart();
    }

    private void onKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE) {
            stage.close();
        }
    }

}
