package com.thm.photoviewer.photoview.states;

import com.thm.common.ModuloArray;
import com.thm.photoviewer.photoview.PhotoCell;
import com.thm.photoviewer.photoview.PhotoViewer;

public abstract class MouseEventState {

    protected final PhotoViewer view;
    protected final ModuloArray<PhotoCell> photoCells;

    public MouseEventState(ModuloArray<PhotoCell> photoCells, PhotoViewer view) {
        this.photoCells = photoCells;
        this.view = view;
    }

    public abstract void OnMousePressed();

    public abstract void OnMouseDragged(double offsetX, double offsetY);

    public abstract void OnMouseReleased();

}
