package cac.components.io.csv;

import cac.components.collection.Array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CsvIterator implements Iterator<Array<String>> {
    private CsvData data;
    private int currentRow;

    public CsvIterator(CsvData data) {
        this.data = data;
        this.currentRow = 0;
    }

    @Override
    public boolean hasNext() {
        return currentRow == data.dimension().getNumRows();
    }

    @Override
    public Array<String> next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Iterator has run out of elements");
        }
        Array<String> row = data.getRow(currentRow);
        currentRow++;
        return row;
    }
}
