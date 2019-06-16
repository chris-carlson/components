package cac.components.ui.attribute;

import java.awt.Component;

public interface Focusable {
    Component getRep();

    default void requestFocus() {
        getRep().requestFocusInWindow();
    }
}
