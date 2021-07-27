package cac.components.collection;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@EqualsAndHashCode
@ToString
public class Grid<E> implements Iterable<E> {
    private GridDimension dimension;
    private Array<Array<E>> rep;

    public Grid(GridDimension dimension) {
        this.dimension = dimension;
        rep = new Array<>(dimension.getNumRows());
        for (int index = 0; index < rep.length(); index++) {
            rep.set(index, new Array<>(dimension.getNumColumns()));
        }
    }

    Grid(Array<Array<E>> rep) {
        int numColumns = rep.length() > 0 ? rep.get(0).length() : 0;
        dimension = new GridDimension(rep.length(), numColumns);
        this.rep = rep;
    }

    public boolean isValid(Position position) {
        return position.getRow() < dimension.getNumRows() && position.getColumn() < dimension.getNumColumns();
    }

    public boolean isSet(Position position) {
        if (!isValid(position)) {
            throw new IllegalArgumentException("Position " + position + " must be in the bounds of the grid");
        }
        Array<E> row = rep.get(position.getRow());
        return row.isSet(position.getColumn());
    }

    public GridDimension dimension() {
        return dimension;
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
        if (!isRowValid(rowIndex)) {
            throw new IllegalArgumentException("Row position \"" + rowIndex + "\" must be in the bounds of the grid");
        }
        return rep.get(rowIndex);
    }

    public Array<E> getColumn(int columnIndex) {
        if (!isColumnValid(columnIndex)) {
            throw new IllegalArgumentException(
                    "Column position \"" + columnIndex + "\" must be in the bounds of the grid");
        }
        Array<E> column = new Array<>(dimension.getNumRows());
        for (int rowIndex = 0; rowIndex < dimension.getNumRows(); rowIndex++) {
            Array<E> row = rep.get(rowIndex);
            column.set(rowIndex, row.get(columnIndex));
        }
        return column;
    }

    public Grid<E> getSubGrid(Position startingPosition, GridDimension subGridDimension) {
        if (!isSubGridValid(startingPosition, subGridDimension)) {
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

    private boolean isRowValid(int rowIndex) {
        return rowIndex >= 0 && rowIndex < dimension.getNumRows();
    }

    private boolean isColumnValid(int columnIndex) {
        return columnIndex >= 0 && columnIndex < dimension.getNumColumns();
    }

    private boolean isSubGridValid(Position startingPosition, GridDimension subGridDimension) {
        boolean isRowValid = startingPosition.getRow() + subGridDimension.getNumRows() - 1 < dimension.getNumRows();
        boolean isColumnValid =
                startingPosition.getColumn() + subGridDimension.getNumColumns() - 1 < dimension.getNumColumns();
        return isRowValid && isColumnValid;
    }

    private List<E> toList() {
        List<E> items = new ArrayList<>();
        for (Array<E> column : rep) {
            for (E item : column) {
                items.add(item);
            }
        }
        return items;
    }

    public Stream<E> stream() {
        List<E> items = toList();
        return items.stream();
    }

    @Override
    public Iterator<E> iterator() {
        List<E> items = toList();
        return items.iterator();
    }
}
