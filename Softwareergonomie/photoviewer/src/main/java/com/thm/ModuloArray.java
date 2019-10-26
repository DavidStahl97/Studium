package com.thm;

import java.util.ArrayList;

public class ModuloArray<T> extends ArrayList<T>{

    public T getLeft(int index) {
        var leftIndex =  (index + super.size() - 1) % super.size();
        return super.get(leftIndex);
    }

    public T getLeft(T element) {
        return getLeft(super.indexOf(element));
    }

    public T getRight(int index) {
        var rightIndex = (index + 1) % super.size();
        return super.get(rightIndex);
    }

    public T getRight(T element) {
        return getRight(super.indexOf(element));
    }

}
