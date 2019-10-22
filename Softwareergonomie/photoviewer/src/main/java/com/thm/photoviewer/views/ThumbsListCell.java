package com.thm.photoviewer.views;

import com.thm.photoviewer.models.Photo;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ThumbsListCell extends ListCell<Photo> {

    private Pane pane;
    private ImageView imageView;
    private Text text;

    @Override
    protected void updateItem(Photo item, boolean empty) {
        super.updateItem(item, empty);

        if(empty)
            return;

        pane = new Pane();
        text = new Text();
        var name = item.getName();
        text.setText(name);
        pane.getChildren().add(text);

        super.setGraphic(text);
    }
}
