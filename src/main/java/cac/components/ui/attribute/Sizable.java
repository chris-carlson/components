package cac.components.ui.attribute;

import cac.components.ui.Dimension;

import java.awt.Container;

public interface Sizable {
    Container getRep();

    default void setSize(Dimension dimension) {
        getRep().setPreferredSize(dimension.getRep());
        getRep().setMinimumSize(dimension.getRep());
        getRep().setMaximumSize(dimension.getRep());
    }
}
