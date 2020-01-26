package cac.components.ui.attribute;

import cac.components.collection.GridDimension;
import cac.components.ui.UiDimension;
import cac.components.ui.component.Container;
import cac.components.ui.layout.GridLayout;
import cac.components.ui.layout.Layout;
import cac.components.ui.layout.LayoutDirection;
import cac.components.ui.layout.LineLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.LayoutManager;
import java.util.List;

public interface Holder {
    java.awt.Container getRep();
    List<Holdable> getComponents();

    default void add(Holdable holdable) {
        getRep().add(holdable.getRep());
        getComponents().add(holdable);
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

    default Layout getLayout() {
        LayoutManager layoutRep = getRep().getLayout();
        if (layoutRep.getClass().equals(BoxLayout.class)) {
            BoxLayout boxLayoutRep = (BoxLayout) layoutRep;
            LayoutDirection direction = boxLayoutRep.getAxis() == BoxLayout.X_AXIS ? LayoutDirection.LEFT_TO_RIGHT : LayoutDirection.TOP_TO_BOTTOM;
            return new LineLayout((Container) this, direction);
        }
        if (layoutRep.getClass().equals(java.awt.GridLayout.class)) {
            java.awt.GridLayout gridLayoutRep = (java.awt.GridLayout) layoutRep;
            return new GridLayout(new GridDimension(gridLayoutRep.getRows(), gridLayoutRep.getColumns()));
        }
        return null;
    }

    default void setLayout(Layout layout) {
        getRep().setLayout(layout.getRep());
    }
}
