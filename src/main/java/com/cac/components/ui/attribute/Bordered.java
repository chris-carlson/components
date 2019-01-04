package com.cac.components.ui.attribute;

import com.cac.components.ui.border.Border;

import javax.swing.JComponent;

public interface Bordered {
    JComponent getRep();

    default void setBorder(Border border) {
        getRep().setBorder(border.getRep());
    }
}
