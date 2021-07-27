package cac.components.ui.attribute;

import cac.components.ui.listener.key.KeyListener;

import java.awt.Component;

public interface Typeable {
    Component getRep();

    default void addKeyListener(KeyListener listener) {
        getRep().addKeyListener(listener.getRep());
    }

    default void removeKeyListener(KeyListener listener) {
        getRep().removeKeyListener(listener.getRep());
    }
}
