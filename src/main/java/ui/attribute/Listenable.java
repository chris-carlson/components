package ui.attribute;

import ui.listener.key.KeyListener;
import ui.listener.mouse.MouseListener;

import java.awt.Component;

public interface Listenable {
    Component getRep();

    default void addMouseListener(MouseListener listener) {
        getRep().addMouseListener(listener.getRep());
    }

    default void addKeyListener(KeyListener listener) {
        getRep().addKeyListener(listener.getRep());
    }
}
