package cac.components.ui.attribute;

import java.awt.Component;

public interface Focusable {
    Component getRep();

    default boolean hasFocus() {
        return getRep().hasFocus();
    }

    default void requestFocus() {
        getRep().requestFocusInWindow();
    }
}
