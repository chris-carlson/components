package com.cac.components.observer;

import java.util.List;

public interface ItemPublisher<E> {
    List<ItemSubscriber<E>> getSubscribers();

    default void addSubscriber(ItemSubscriber<E> subscriber) {
        getSubscribers().add(subscriber);
    }

    default void removeSubscriber(ItemSubscriber<E> subscriber) {
        getSubscribers().remove(subscriber);
    }

    default void notifySubscribers(E item) {
        for (ItemSubscriber<E> subscriber : getSubscribers()) {
            subscriber.update(item);
        }
    }
}
