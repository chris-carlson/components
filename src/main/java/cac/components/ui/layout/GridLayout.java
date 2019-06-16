package cac.components.ui.layout;

import cac.components.collection.Dimension;

import java.awt.LayoutManager;

public class GridLayout implements Layout {
    private LayoutManager rep;

    public GridLayout(Dimension dimension) {
        rep = new java.awt.GridLayout(dimension.getNumRows(), dimension.getNumColumns());
    }

    @Override
    public LayoutManager getRep() {
        return rep;
    }
}
