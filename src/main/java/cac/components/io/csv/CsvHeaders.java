package cac.components.io.csv;

import java.util.List;

public class CsvHeaders {
    private List<String> headers;

    public CsvHeaders(List<String> headers) {
        this.headers = headers;
    }

    public int getIndex(String header) {
        return headers.indexOf(header);
    }
}
