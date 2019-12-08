package com.thm.common;

import java.util.ArrayList;

public class ModuloArray<T> extends ArrayList<T> {

    private int centerIndex = 0;

    public void setCenterIndex(int index) {
        this.centerIndex = index;
    }

    public T getCenter() {
        return this.get(centerIndex);
    }

    public T getLeft() {
        var leftIndex =  (centerIndex + super.size() - 1) % super.size();
        return super.get(leftIndex);
    }

    public T getRight() {
        var rightIndex = (centerIndex + 1) % super.size();
        return super.get(rightIndex);
    }

    @Override
    public T get(int index) {
        var i = index % size();
        return super.get(i);
    }
}
