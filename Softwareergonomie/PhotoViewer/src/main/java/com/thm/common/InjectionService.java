package com.thm.common;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class InjectionService {

    private static InjectionService instance;
    public static InjectionService getInstance() {
        if(instance == null) {
            instance = new InjectionService();
        }
        return instance;
    }

    private InjectionService() {}

    private Object placeholder = new Object();
    private Hashtable<String, Object> singletonTable = new Hashtable<>();

    public <T> void registerSingleton(Class<T> cl) {
        singletonTable.put(cl.getName(), placeholder);
    }

    public <T> T getInstance(Class<T> cl) {
        return getInstance(cl, new Object[] {});
    }

    public <T> T getInstance(Class<T> cl, Object... obj) {
        var constructors = cl.getConstructors();
        if(constructors.length > 1) {
            throw new RuntimeException("Only one constructor allowed");
        }

        var constructor = constructors[0];
        var parameterTypes = constructor.getParameterTypes();

        var parameter = new ArrayList<>();
        for(var type : parameterTypes) {
            var find = Arrays.stream(obj).filter(o -> type.equals(o.getClass())).findAny();
            var p = find.isEmpty() ? getSingleton(type) : find.get();
            parameter.add(p);
        }

        Object instance = null;
        try {
            instance = constructor.newInstance(parameter.toArray());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return (T) instance;
    }

    public <T> T getSingleton(Class<T> type) {
        var singleton = singletonTable.get(type.getName());
        if(singleton.equals(placeholder)) {
            singleton = getInstance(type);
            singletonTable.put(type.getName(), singleton);
        }
        return (T) singleton;
    }
}
