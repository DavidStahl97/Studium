package com.thm.photoviewer;

import com.thm.photoviewer.photoview.PhotoViewer;
import com.thm.photoviewer.thumbs.ThumbList;
import com.thm.photoviewer.topbar.TopBar;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class Shell extends BorderPane {

    private TopBar topBar;

    private BorderPane centerPane;
    private PhotoViewer photoViewer;
    private ThumbList thumbList;

    public Shell() {
        // children
        topBar = new TopBar();
        super.setTop(topBar);

        // center pane
        centerPane = new BorderPane();
        centerPane.setPadding(new Insets(5,5,5,10));
        super.setCenter(centerPane);

        photoViewer = new PhotoViewer();
        centerPane.setCenter(photoViewer);

        thumbList = new ThumbList();
        centerPane.setBottom(thumbList);
    }

}
