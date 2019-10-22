package com.thm.photoviewer;

import java.lang.reflect.InvocationTargetException;

public class GenericCreateFactory<T> {

    private Class<T> clazz;

    public GenericCreateFactory(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T createInstance() {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

}
