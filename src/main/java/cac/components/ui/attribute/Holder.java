package cac.components.ui.attribute;

import cac.components.ui.Dimension;

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

    default void addGap(int size, Axis axis) {
        if (axis == Axis.HORIZONTAL) {
            addGap(new Dimension(size, 0));
        } else {
            addGap(new Dimension(0, size));
        }
    }

    default void addGlue(Axis axis) {
        if (axis == Axis.HORIZONTAL) {
            getRep().add(Box.createHorizontalGlue());
        } else {
            getRep().add(Box.createVerticalGlue());
        }
    }
}
