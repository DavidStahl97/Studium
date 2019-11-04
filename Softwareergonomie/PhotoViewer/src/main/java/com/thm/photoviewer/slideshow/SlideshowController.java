package com.thm.photoviewer.slideshow;

import com.thm.photoviewer.BaseController;
import com.thm.photoviewer.models.Direction;
import com.thm.photoviewer.models.PhotoList;
import com.thm.photoviewer.photoview.PhotoCell;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SlideshowController extends BaseController<Slideshow> {

    private PhotoList photoList;

    private static final double SLIDER_RATIO = 10;
    private double duration = 2;

    private boolean isShowing = false;

    public SlideshowController(Slideshow view, PhotoList photoList) {
        super(view);
        this.photoList = photoList;

        view.getSlider().setValue(duration * SLIDER_RATIO - 1);
        view.getSlider().valueProperty().addListener((observable, oldValue, newValue) -> {
            duration = (newValue.doubleValue() + 1) / SLIDER_RATIO;
        });

        view.getExpandButton().setOnAction(event -> onFullscreen());
    }

    @Override
    protected void initialized() {
        var stage = super.getStage();

        stage.fullScreenProperty().addListener((observable1, oldFullscreen, newFullscreen) -> {
            if(newFullscreen == false) {
                view.getExpandButton().setVisible(true);
            }
        });

        stage.showingProperty().addListener((observable, oldValue, newValue) -> showingChanged(newValue));
    }

    private void onFullscreen() {
        super.getStage().setFullScreen(true);
        view.getExpandButton().setVisible(false);
    }

    private void showingChanged(Boolean showing) {
        if(showing) {
            start();
        }
        else {
            stop();
        }
    }

    public void start() {
        isShowing = true;

        var photoCellOne = view.getPhotoCellOne();
        var photoCellTwo = view.getPhotoCellTwo();

        photoCellOne.setPhoto(photoList.getSelectedPhoto());
        photoCellTwo.setPhoto(photoList.getNextPhoto(Direction.RIGHT));
        transition(photoCellOne, photoCellTwo);
    }

    public void stop() {
        isShowing = false;
    }

    private void transition(PhotoCell first, PhotoCell second) {
        var fadeout = new FadeTransition(Duration.seconds(duration), first);
        fadeout.setFromValue(1);
        fadeout.setToValue(0);

        var fadein = new FadeTransition(Duration.seconds(duration), second);
        fadein.setFromValue(0);
        fadein.setToValue(1);

        var parallel = new ParallelTransition(fadein, fadeout);
        parallel.setOnFinished(event -> {
            if(isShowing == false) {
                return;
            }

            var currentPhoto = photoList.getNextPhoto(Direction.RIGHT);
            if(second.getPhoto().equals(currentPhoto) == false) {
                second.setPhoto(currentPhoto);
            }

            photoList.setSelectedPhoto(currentPhoto);
            first.setPhoto(photoList.getNextPhoto(Direction.RIGHT));

            var delay = new PauseTransition(Duration.seconds(duration));
            delay.setOnFinished(event1 -> transition(second, first));
            delay.playFromStart();
        });

        parallel.playFromStart();
    }
}