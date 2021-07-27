package cac.components.collection;

public record GridDimension(int numRows, int numColumns) {
    public GridDimension {
        if (numRows < 0 || numColumns < 0) {
            throw new IllegalArgumentException(
                    "The number of rows \"" + numRows + "\" and number of columns \"" + numColumns +
                    "\" must be non-negative");
        }
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }
}
