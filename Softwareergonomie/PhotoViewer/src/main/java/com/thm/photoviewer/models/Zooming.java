package com.thm.photoviewer.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Zooming {

    private ObjectProperty<Number> zoomValue = new SimpleObjectProperty<>();

    public double getZoomValue() {
        return zoomValue.get().doubleValue();
    }

    public void setZoomValue(double value) {
        zoomValue.set(value);
    }

    public boolean zoomed() {
        return getZoomValue() > 1;
    }

    public ObjectProperty<Number> zoomValueProperty() {
        return zoomValue;
    }

}
