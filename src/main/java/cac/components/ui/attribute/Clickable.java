package cac.components.ui.attribute;

import cac.components.ui.listener.mouse.MouseListener;

import java.awt.Component;

public interface Clickable {
    Component getRep();

    default void addMouseListener(MouseListener listener) {
        getRep().addMouseListener(listener.getRep());
    }

    default void removeMouseListener(MouseListener listener) {
        getRep().removeMouseListener(listener.getRep());
    }
}
