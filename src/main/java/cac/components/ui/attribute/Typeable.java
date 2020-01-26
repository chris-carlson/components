package cac.components.ui.attribute;

import java.awt.Component;
import java.util.List;

import cac.components.ui.listener.key.KeyListener;

public interface Typeable {
    Component getRep();
    List<KeyListener> getKeyListeners();

    default void addKeyListener(KeyListener listener) {
        getRep().addKeyListener(listener.getRep());
        getKeyListeners().add(listener);
    }

    default void removeKeyListener(KeyListener listener) {
        getRep().removeKeyListener(listener.getRep());
        getKeyListeners().remove(listener);
    }
}
