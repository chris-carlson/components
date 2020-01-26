package cac.components.ui.attribute;

import cac.components.ui.listener.window.WindowListener;

import java.awt.Window;
import java.util.List;

public interface Windowed {
    Window getRep();
    List<WindowListener> getWindowListeners();

    default void addWindowListener(WindowListener listener) {
        getRep().addWindowListener(listener.getRep());
    }

    default void removeWindowListener(WindowListener listener) {
        getRep().removeWindowListener(listener.getRep());
    }
}
