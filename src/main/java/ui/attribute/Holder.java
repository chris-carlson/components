package ui.attribute;

import java.awt.Container;

public interface Holder {
    Container getRep();

    default void add(Holdable holdable) {
        getRep().add(holdable.getRep());
    }
}
