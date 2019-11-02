package com.thm.photoviewer.controller;

import com.thm.photoviewer.App;
import com.thm.photoviewer.NextDirection;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NextButton extends Button implements Initializable {

    public NextButton() {
        var url = App.class.getResource("next_button" + ".fxml");
        var fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.setCursor(Cursor.HAND);
    }

    private ObjectProperty<NextDirection> direction = new SimpleObjectProperty<>();

    public final void setDirection(NextDirection nextDirection) {
        directionProperty().set(nextDirection);

        var icon = new FontIcon();
        var name = nextDirection == NextDirection.LEFT ? "dashicons-arrow-left-alt2" : "dashicons-arrow-right-alt2";
        icon.setIconLiteral(name);
        icon.setOpacity(1);
        super.setGraphic(icon);
    }

    public final NextDirection getDirection() {
        return direction == null ? null : direction.get();
    }

    public final ObjectProperty<NextDirection> directionProperty() {
        return direction;
    }

}
