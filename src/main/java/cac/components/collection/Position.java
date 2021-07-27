package cac.components.collection;

public record Position(int row, int column) {
    public Position {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException(
                    "The getRow \"" + row + "\" and getColumn \"" + column + "\" must be non-negative");
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
