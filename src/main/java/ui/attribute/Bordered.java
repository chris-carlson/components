package ui.attribute;

import ui.border.Border;

import javax.swing.JComponent;

public interface Bordered {
    JComponent getRep();

    default void setBorder(Border border) {
        getRep().setBorder(border.getRep());
    }
}
