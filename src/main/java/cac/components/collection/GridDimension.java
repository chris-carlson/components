package cac.components.collection;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class GridDimension {
    private int numRows;
    private int numColumns;

    public GridDimension(int numRows, int numColumns) {
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
}
