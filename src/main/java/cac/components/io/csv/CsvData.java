package cac.components.io.csv;

import cac.components.collection.Array;
import cac.components.collection.GridDimension;
import cac.components.collection.Grid;

import java.util.Iterator;

public class CsvData implements Iterable<Array<String>> {
    private CsvHeaders headers;
    private Grid<String> data;

    public CsvData(CsvHeaders headers, Grid<String> data) {
        this.headers = headers;
        this.data = data;
    }

    public GridDimension getDimension() {
        return data.getDimension();
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
