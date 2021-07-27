package cac.components.ui.layout;

import cac.components.collection.GridDimension;
import lombok.EqualsAndHashCode;

import java.awt.LayoutManager;

@EqualsAndHashCode
public class GridLayout implements Layout {
    private final LayoutManager rep;

    public GridLayout(GridDimension dimension) {
        rep = new java.awt.GridLayout(dimension.getNumRows(), dimension.getNumColumns());
    }

    @Override
    public LayoutManager getRep() {
        return rep;
    }
}
