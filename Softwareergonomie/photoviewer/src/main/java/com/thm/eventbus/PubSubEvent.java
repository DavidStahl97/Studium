package com.thm.eventbus;

import java.util.ArrayList;
import java.util.List;

public abstract class PubSubEvent<T> {

    private List<ISubscription<T>> subscriptions = new ArrayList<>();

    public void subscripe(ISubscription<T> subscription) {
        subscriptions.add(subscription);
    }

    public void publish(T element) {
        for (var s : subscriptions) {
            s.handle(element);
        }
    }

}
