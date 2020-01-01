package cac.components.collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid<E> implements Iterable<Position> {
    private Dimension dimension;
    private Array<Array<E>> rep;

    public Grid(Dimension dimension) {
        this.dimension = dimension;
        rep = new Array<>(dimension.getNumRows());
        for (int index = 0; index < rep.getLength(); index++) {
            rep.set(index, new Array<>(dimension.getNumColumns()));
        }
    }

    Grid(Array<Array<E>> rep) {
        int numColumns = 0;
        if (rep.getLength() > 0) {
            numColumns = rep.get(0).getLength();
        }
        dimension = new Dimension(rep.getLength(), numColumns);
        this.rep = rep;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public boolean isValid(Position position) {
        return position.getRow() < dimension.getNumRows() && position.getColumn() < dimension.getNumColumns();
    }

    public E get(Position position) {
        if (!isValid(position)) {
            throw new IllegalArgumentException("Position " + position + " must be in the bounds of the grid");
        }
        Array<E> row = rep.get(position.getRow());
        if (!row.isSet(position.getColumn())) {
            throw new IllegalArgumentException("Element at position \"" + position + "\" has not been set");
        }
        return row.get(position.getColumn());
    }

    public void set(Position position, E element) {
        if (!isValid(position)) {
            throw new IllegalArgumentException("Position " + position + " must be in the bounds of the grid");
        }
        if (element == null) {
            throw new IllegalArgumentException("An array cannot have any null elements");
        }
        Array<E> row = rep.get(position.getRow());
        row.set(position.getColumn(), element);
    }

    public Array<E> getRow(int rowIndex) {
        if (rowIndex >= dimension.getNumRows()) {
            throw new IllegalArgumentException("Row position \"" + rowIndex + "\" must be in the bounds of the grid");
        }
        return rep.get(rowIndex);
    }

    public Array<E> getColumn(int columnIndex) {
        if (columnIndex >= dimension.getNumRows()) {
            throw new IllegalArgumentException(
                    "Column position \"" + columnIndex + "\" must be in the bounds of the grid");
        }
        Array<E> column = new Array<>(dimension.getNumRows());
        for (int rowIndex = 0; rowIndex < dimension.getNumRows(); rowIndex++) {
            Array<E> row = getRow(rowIndex);
            column.set(rowIndex, row.get(columnIndex));
        }
        return column;
    }

    public Grid<E> getSubGrid(Position startingPosition, Dimension subGridDimension) {
        if (startingPosition.getRow() + subGridDimension.getNumRows() - 1 >= dimension.getNumRows() ||
            startingPosition.getColumn() + subGridDimension.getNumColumns() - 1 >= dimension.getNumColumns()) {
            throw new IllegalArgumentException("Position " + startingPosition + " and dimension " + subGridDimension +
                                               " must be in the bounds of the grid");
        }
        Grid<E> box = new Grid<>(subGridDimension);
        for (int rowIndex = 0; rowIndex < subGridDimension.getNumRows(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < subGridDimension.getNumColumns(); columnIndex++) {
                Position boxPosition = new Position(rowIndex, columnIndex);
                Position cellPosition =
                        new Position(startingPosition.getRow() + rowIndex, startingPosition.getColumn() + columnIndex);
                box.set(boxPosition, get(cellPosition));
            }
        }
        return box;
    }

    public List<E> toList() {
        List<E> list = new ArrayList<>();
        for (Position position : this) {
            list.add(get(position));
        }
        return list;
    }

    @Override
    public Iterator<Position> iterator() {
        return new PositionIterator(dimension);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rep).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Grid<?> other = (Grid<?>) obj;
        return new EqualsBuilder().append(rep, other.rep).isEquals();
    }

    @Override
    public String toString() {
        return rep.toString();
    }
}
