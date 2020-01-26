package cac.components.ui.attribute;

import java.awt.Component;
import java.util.List;

import cac.components.ui.listener.mouse.MouseListener;

public interface Clickable {
    Component getRep();
    List<MouseListener> getMouseListeners();

    default void addMouseListener(MouseListener listener) {
        getRep().addMouseListener(listener.getRep());
        getMouseListeners().add(listener);
    }

    default void removeMouseListener(MouseListener listener) {
        getRep().removeMouseListener(listener.getRep());
        getMouseListeners().remove(listener);
    }
}
