package cac.components.ui.attribute;

import cac.components.ui.listener.window.WindowListener;

import java.awt.Window;

public interface Windowed {
    Window getRep();

    default void addWindowListener(WindowListener listener) {
        getRep().addWindowListener(listener.getRep());
    }
}
