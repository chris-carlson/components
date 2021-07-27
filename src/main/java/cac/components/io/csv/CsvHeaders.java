package cac.components.io.csv;

import java.util.List;

public record CsvHeaders(List<String> headers) {
    public int getIndex(String header) {
        return headers.indexOf(header);
    }
}
