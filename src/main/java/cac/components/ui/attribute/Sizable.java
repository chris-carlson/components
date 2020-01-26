package cac.components.ui.attribute;

import cac.components.ui.UiDimension;

import java.awt.Container;
import java.awt.Dimension;

public interface Sizable {
    Container getRep();

    default UiDimension getSize() {
        Dimension dimension = getRep().getPreferredSize();
        return new UiDimension((int) dimension.getWidth(), (int) dimension.getHeight());
    }

    default void setSize(UiDimension dimension) {
        getRep().setPreferredSize(dimension.getRep());
        getRep().setMinimumSize(dimension.getRep());
        getRep().setMaximumSize(dimension.getRep());
    }
}
