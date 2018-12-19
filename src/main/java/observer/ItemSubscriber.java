package observer;

public interface ItemSubscriber<E> {
    void update(E item);
}
