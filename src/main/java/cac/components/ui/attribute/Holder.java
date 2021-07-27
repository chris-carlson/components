package cac.components.ui.attribute;

import cac.components.ui.UiDimension;
import cac.components.ui.layout.Layout;

import javax.swing.Box;

public interface Holder {
    java.awt.Container getRep();

    default void add(Holdable holdable) {
        getRep().add(holdable.getRep());
        getRep().setMinimumSize(getRep().getPreferredSize());
        getRep().setMaximumSize(getRep().getPreferredSize());
    }

    default void addGap(UiDimension dimension) {
        getRep().add(Box.createRigidArea(dimension.getRep()));
    }

    default void addGap(int size, Axis axis) {
        if (axis == Axis.HORIZONTAL) {
            addGap(new UiDimension(size, 0));
        } else {
            addGap(new UiDimension(0, size));
        }
    }

    default void addGlue(Axis axis) {
        if (axis == Axis.HORIZONTAL) {
            getRep().add(Box.createHorizontalGlue());
        } else {
            getRep().add(Box.createVerticalGlue());
        }
    }

    default void setLayout(Layout layout) {
        getRep().setLayout(layout.getRep());
    }
}
