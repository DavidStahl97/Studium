package com.thm.eventbus;

public interface ISubscription<T> {

    void handle(T element);

}
