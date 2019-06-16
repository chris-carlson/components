package cac.components.io.csv;

import cac.components.collection.Dimension;
import cac.components.collection.Grid;
import cac.components.collection.Position;
import cac.components.io.path.File;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {
    private static final Logger LOGGER = LogManager.getLogger();

    private CsvData data;

    public CsvReader(File file) {
        try {
            try (Reader reader = Files.newBufferedReader(Paths.get(file.getPath()))) {
                CSVParser parser = new CSVParser(reader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
                data = readData(parser);
            }
        } catch (IOException exception) {
            LOGGER.error("Could not parse CSV file \"" + file.getPath() + "\"");
        }
    }

    public CsvData getData() {
        return data;
    }

    private CsvData readData(CSVParser parser) {
        try {
            List<CSVRecord> records = parser.getRecords();
            CsvHeaders headers = readHeaders(parser.getHeaderMap());
            Grid<String> grid = new Grid<>(getDimension(records));
            for (Position position : grid) {
                grid.set(position, records.get(position.getRow()).get(position.getColumn()));
            }
            return new CsvData(headers, grid);
        } catch (IOException e) {
            LOGGER.error("Could not read CSV records");
        }
        return null;
    }

    private CsvHeaders readHeaders(Map<String, Integer> headerMap) {
        List<String> headerNames = new ArrayList<>();
        Map<Integer, String> indexedHeaderMap = new HashMap<>();
        for (Map.Entry<String, Integer> headerEntry : headerMap.entrySet()) {
            indexedHeaderMap.put(headerEntry.getValue(), headerEntry.getKey());
        }
        for (int index = 0; index < indexedHeaderMap.size(); index++) {
            headerNames.add(indexedHeaderMap.get(index));
        }
        return new CsvHeaders(headerNames);
    }

    private Dimension getDimension(List<CSVRecord> records) {
        int numColumns = 0;
        if (!records.isEmpty()) {
            numColumns = records.get(0).size();
        }
        return new Dimension(records.size(), numColumns);
    }
}