package com.thm.javafxmvc.selection;

import javafx.beans.property.*;
import javafx.css.PseudoClass;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;

class Bulb extends Circle implements Toggle {
    private ObjectProperty<ToggleGroup> toggleGroup = new SimpleObjectProperty<>();

    Bulb() {
        super(30);
        getStyleClass().add("bulb");
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    @Override
    public boolean isSelected() {
        return selected.get();
    }

    @Override
    public BooleanProperty selectedProperty() {
        return selected;
    }

    public BooleanProperty selected =
            new BooleanPropertyBase(false) {
                @Override protected void invalidated() {
                    pseudoClassStateChanged(ON_PSEUDO_CLASS, get());
                }

                @Override public Object getBean() {
                    return Bulb.this;
                }

                @Override public String getName() {
                    return "on";
                }
            };

    private static final PseudoClass
            ON_PSEUDO_CLASS = PseudoClass.getPseudoClass("on");

    @Override
    public ToggleGroup getToggleGroup() {
        return toggleGroup.get();
    }

    @Override
    public void setToggleGroup(ToggleGroup toggleGroup) {
        this.toggleGroup.set(toggleGroup);
    }

    @Override
    public ObjectProperty<ToggleGroup> toggleGroupProperty() {
        return toggleGroup;
    }
}
