package ui.layout;

import data.GridDimension;

import java.awt.LayoutManager;

public class GridLayout implements Layout {
    private LayoutManager rep;

    public GridLayout(GridDimension dimension) {
        rep = new java.awt.GridLayout(dimension.getNumRows(), dimension.getNumColumns());
    }

    @Override
    public LayoutManager getRep() {
        return rep;
    }
}
