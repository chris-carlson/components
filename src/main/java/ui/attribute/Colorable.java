package ui.attribute;

import ui.Color;

import javax.swing.JComponent;

public interface Colorable {
    JComponent getRep();

    default void setBackground(Color color) {
        getRep().setBackground(color.getRep());
    }
}
