package cac.components.io.csv;

import cac.components.collection.Array;
import cac.components.collection.Grid;
import cac.components.collection.GridDimension;

import java.util.Iterator;

public record CsvData(CsvHeaders headers, Grid<String> data) implements Iterable<Array<String>> {
    public GridDimension dimension() {
        return data.dimension();
    }

    public Array<String> getRow(int index) {
        return data.getRow(index);
    }

    public Array<String> getColumn(int index) {
        return data.getColumn(index);
    }

    public Array<String> getColumn(String header) {
        return data.getColumn(headers.getIndex(header));
    }

    @Override
    public Iterator<Array<String>> iterator() {
        return new CsvIterator(this);
    }
}
