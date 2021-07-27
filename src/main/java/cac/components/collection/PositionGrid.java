package cac.components.collection;

import java.util.Iterator;

public record PositionGrid(GridDimension dimension) implements Iterable<Position> {
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
