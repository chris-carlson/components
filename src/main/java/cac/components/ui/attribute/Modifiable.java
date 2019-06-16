package cac.components.ui.attribute;

import cac.components.ui.listener.key.KeyListener;
import cac.components.ui.listener.mouse.MouseListener;

import java.awt.Component;

public interface Modifiable {
    Component getRep();

    default void addMouseListener(MouseListener listener) {
        getRep().addMouseListener(listener.getRep());
    }

    default void addKeyListener(KeyListener listener) {
        getRep().addKeyListener(listener.getRep());
    }
}
