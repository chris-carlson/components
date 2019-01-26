package com.cac.components.ui.attribute;

import com.cac.components.ui.Dimension;

import javax.swing.Box;
import java.awt.Container;

public interface Holder {
    Container getRep();

    default void add(Holdable holdable) {
        getRep().add(holdable.getRep());
    }

    default void addGap(Dimension dimension) {
        getRep().add(Box.createRigidArea(dimension.getRep()));
    }
}
