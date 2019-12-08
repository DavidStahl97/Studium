package com.thm.photoviewer.photoview.states;

import com.thm.common.MathUtil;
import com.thm.common.ModuloArray;
import com.thm.photoviewer.photoview.PhotoCell;
import com.thm.photoviewer.photoview.PhotoViewer;
import javafx.geometry.Rectangle2D;

public class ZoomedMouseEventState extends MouseEventState {

    public ZoomedMouseEventState(ModuloArray<PhotoCell> photoCells, PhotoViewer view) {
        super(photoCells, view);
    }

    @Override
    public void OnMousePressed() { }

    @Override
    public void OnMouseDragged(double offsetX, double offsetY) {
        zoomMove(offsetX, offsetY);
    }

    @Override
    public void OnMouseReleased() { }

    private void zoomMove(double offsetX, double offsetY) {
        var imageView = photoCells.getCenter().getImageView();
        var image = imageView.getImage();
        var rectangle = imageView.getViewport();

        double newX = MathUtil.clamp(rectangle.getMinX() - offsetX, 0, image.getWidth() - rectangle.getWidth());
        double newY = MathUtil.clamp(rectangle.getMinY() - offsetY, 0, image.getHeight() - rectangle.getHeight());

        var newRectangle = new Rectangle2D(newX, newY, rectangle.getWidth(), rectangle.getHeight());
        imageView.setViewport(newRectangle);
    }
}