package cac.components.ui.attribute;

import cac.components.ui.color.Color;

import javax.swing.JComponent;

public interface Colorable {
    JComponent getRep();

    default void setBackground(Color color) {
        getRep().setBackground(color.getRep());
    }

    default void setForeground(Color color) {
        getRep().setForeground(color.getRep());
    }
}
