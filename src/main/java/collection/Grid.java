package collection;

import data.GridDimension;
import data.Position;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Grid<E> {
    private GridDimension dimension;
    private Array<Array<E>> rep;

    public Grid(GridDimension dimension) {
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
        dimension = new GridDimension(rep.getLength(), numColumns);
        this.rep = rep;
    }

    public GridDimension getDimension() {
        return dimension;
    }

    public E get(Position position) {
        if (position.getRow() >= dimension.getNumRows() || position.getColumn() >= dimension.getNumColumns()) {
            throw new IllegalArgumentException(
                "Row position \"" + position.getRow() + "\" and getColumn position \"" + position.getColumn() +
                    "\" must be in the bounds of the array");
        }
        Array<E> row = rep.get(position.getRow());
        if (!row.isSet(position.getColumn())) {
            throw new IllegalArgumentException("Element at position \"" + position + "\" has not been set");
        }
        return row.get(position.getColumn());
    }

    public void set(Position position, E element) {
        if (position.getRow() >= dimension.getNumRows() || position.getColumn() >= dimension.getNumColumns()) {
            throw new IllegalArgumentException(
                "Row position \"" + position.getRow() + "\" and getColumn position \"" + position.getColumn() +
                    "\" must be in the bounds of the array");
        }
        if (element == null) {
            throw new IllegalArgumentException("An array cannot have any null elements");
        }
        Array<E> row = rep.get(position.getRow());
        row.set(position.getColumn(), element);
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
        Grid<E> other = (Grid<E>) obj;
        return new EqualsBuilder().append(rep, other.rep).isEquals();
    }

    @Override
    public String toString() {
        return rep.toString();
    }
}
