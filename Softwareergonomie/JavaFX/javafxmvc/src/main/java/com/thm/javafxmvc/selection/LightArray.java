package com.thm.javafxmvc.selection;

import javafx.geometry.Insets;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class LightArray extends HBox {
    public LightArray(Bulb... bulbs) {
        super(10, bulbs);
        setPadding(new Insets(10));

        ToggleGroup toggleGroup = new ToggleGroup();
        for (Bulb bulb: bulbs) {
            bulb.setToggleGroup(toggleGroup);
        }

        setOnMouseClicked(event -> {
            if (event.getTarget() instanceof Bulb) {
                var bulb = (Bulb) event.getTarget();
                bulb.setFill(javafx.scene.paint.Color.RED);
                toggleGroup.selectToggle(bulb);
            } else {
                toggleGroup.selectToggle(null);
            }
        });


    }
}
