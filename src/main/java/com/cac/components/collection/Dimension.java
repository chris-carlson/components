package com.cac.components.collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Dimension {
    private int numRows;
    private int numColumns;

    public Dimension(int numRows, int numColumns) {
        if (numRows < 0 || numColumns < 0) {
            throw new IllegalArgumentException(
                "The number of rows \"" + numRows + "\" and number of columns \"" + numColumns +
                    "\" must be non-negative");
        }
        this.numRows = numRows;
        this.numColumns = numColumns;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(numRows).append(numColumns).toHashCode();
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
        Dimension other = (Dimension) obj;
        return new EqualsBuilder().append(numRows, other.numRows).append(numColumns, other.numColumns).isEquals();
    }

    @Override
    public String toString() {
        return "(" + numRows + ", " + numColumns + ")";
    }
}
