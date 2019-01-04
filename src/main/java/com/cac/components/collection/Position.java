package com.cac.components.collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException(
                "The getRow \"" + row + "\" and getColumn \"" + column + "\" must be non-negative");
        }
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(row).append(column).toHashCode();
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
        Position other = (Position) obj;
        return new EqualsBuilder().append(row, other.row).append(column, other.column).isEquals();
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
