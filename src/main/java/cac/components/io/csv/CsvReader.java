package cac.components.io.csv;

import cac.components.collection.Grid;
import cac.components.collection.GridDimension;
import cac.components.collection.Position;
import cac.components.collection.PositionGrid;
import cac.components.path.File;
import com.google.common.collect.Lists;
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

    private File file;

    public CsvReader(File file) {
        this.file = file;
    }

    public CsvData getData() {
        try {
            try (Reader reader = Files.newBufferedReader(Paths.get(file.getPath()))) {
                CSVParser parser = new CSVParser(reader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
                return readData(parser);
            }
        } catch (IOException exception) {
            LOGGER.error(exception);
        }
        return new CsvData(new CsvHeaders(Lists.newArrayList()), new Grid<>(new GridDimension(0, 0)));
    }

    private CsvData readData(CSVParser parser) {
        try {
            List<CSVRecord> records = parser.getRecords();
            CsvHeaders headers = readHeaders(parser.getHeaderMap());
            Grid<String> grid = new Grid<>(dimension(records));
            PositionGrid positionGrid = new PositionGrid(grid.dimension());
            for (Position position : positionGrid) {
                grid.set(position, records.get(position.getRow()).get(position.getColumn()));
            }
            return new CsvData(headers, grid);
        } catch (IOException exception) {
            LOGGER.error(exception);
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

    private GridDimension dimension(List<CSVRecord> records) {
        int numColumns = 0;
        if (!records.isEmpty()) {
            numColumns = records.get(0).size();
        }
        return new GridDimension(records.size(), numColumns);
    }
}
