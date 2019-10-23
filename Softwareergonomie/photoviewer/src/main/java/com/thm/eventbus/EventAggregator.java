package com.thm.eventbus;

import com.thm.GenericCreateFactory;

import java.util.Hashtable;

public class EventAggregator implements IEventAggregator {

    private Hashtable<String, PubSubEvent> eventTable = new Hashtable<>();

    public <T extends PubSubEvent<E>, E> T getEvent(Class<T> clazz) {
        var pubsubEvent = eventTable.get(clazz.getName());

        if(pubsubEvent == null) {
            var factory = new GenericCreateFactory<T>(clazz);
            var newEvent = factory.createInstance();
            eventTable.put(clazz.getName(), newEvent);
            return newEvent;
        }

        return (T)pubsubEvent;
    }

}
