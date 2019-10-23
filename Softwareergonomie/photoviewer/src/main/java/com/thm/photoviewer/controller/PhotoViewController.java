package com.thm.photoviewer.controller;

import com.thm.eventbus.IEventAggregator;
import com.thm.photoviewer.ControllerBase;
import com.thm.photoviewer.events.SelectThumbEvent;
import com.thm.photoviewer.models.Photo;
import com.thm.photoviewer.views.PhotoView;

public class PhotoViewController extends ControllerBase<PhotoView> {
    public PhotoViewController(IEventAggregator eventAggregator) {
        super(PhotoView.class);

        eventAggregator.getEvent(SelectThumbEvent.class).subscripe(p -> selectPhotoEvent(p));
    }

    private void selectPhotoEvent(Photo p) {

    }
}
