package ui.attribute;

import data.ObjectDimension;

import java.awt.Container;

public interface Sizable {
    Container getRep();

    default void setSize(ObjectDimension dimension) {
        getRep().setPreferredSize(dimension.getRep());
    }
}
