package com.cac.components.ui.attribute;

import javax.swing.JComponent;

public interface Holdable {
    JComponent getRep();

    default void setHorizontalAlignment(Alignment alignment) {
        getRep().setAlignmentX(alignment.getRep());
    }

    default void setVerticalAlignment(Alignment alignment) {
        getRep().setAlignmentY(alignment.getRep());
    }
}
