package com.thm.eventbus;

public interface IEventAggregator {
    <T extends PubSubEvent<E>, E> T getEvent(Class<T> clazz);
}
