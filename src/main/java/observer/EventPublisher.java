package observer;

import java.util.List;

public interface EventPublisher {
    List<EventSubscriber> getSubscribers();

    default void addSubscriber(EventSubscriber subscriber) {
        getSubscribers().add(subscriber);
    }

    default void removeSubscriber(EventSubscriber subscriber) {
        getSubscribers().remove(subscriber);
    }

    default void notifySubscribers() {
        for (EventSubscriber subscriber : getSubscribers()) {
            subscriber.update();
        }
    }
}
