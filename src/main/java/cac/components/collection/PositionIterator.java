package cac.components.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PositionIterator implements Iterator<Position> {
    private Dimension dimension;
    private int currentRow;
    private int currentColumn;

    public PositionIterator(Dimension dimension) {
        this.dimension = dimension;
        currentRow = 0;
        currentColumn = 0;
    }

    PositionIterator(Dimension dimension, int currentRow, int currentColumn) {
        this.dimension = dimension;
        this.currentRow = currentRow;
        this.currentColumn = currentColumn;
    }

    @Override
    public boolean hasNext() {
        return currentRow < dimension.getNumRows();
    }

    @Override
    public Position next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Iterator has run out of elements");
        }
        Position position = new Position(currentRow, currentColumn);
        currentColumn++;
        if (currentColumn == dimension.getNumColumns()) {
            currentRow++;
            currentColumn = 0;
        }
        return position;
    }
}
