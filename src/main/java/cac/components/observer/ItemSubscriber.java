package cac.components.observer;

public interface ItemSubscriber<E> {
    void update(E item);
}
