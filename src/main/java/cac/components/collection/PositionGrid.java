package cac.components.collection;

import java.util.Iterator;

public class PositionGrid implements Iterable<Position> {
    private GridDimension dimension;

    public PositionGrid(GridDimension dimension) {
        this.dimension = dimension;
    }

    public Grid<Position> createGrid() {
        Grid<Position> positions = new Grid<>(dimension);
        for (Position position : this) {
            positions.set(position, position);
        }
        return positions;
    }

    @Override
    public Iterator<Position> iterator() {
        return new PositionIterator(dimension);
    }
}
