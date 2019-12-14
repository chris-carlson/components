package cac.components.io.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.gson.JsonParser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cac.components.path.File;

public class JsonReader {
    private static final Logger LOGGER = LogManager.getLogger();

    private File file;

    public JsonReader(File file) {
        this.file = file;
    }

    public Map<String, JsonElement> readObject() {
        Optional<JsonElement> optionalElement = readElement();
        if (optionalElement.isPresent()) {
            JsonElement element = optionalElement.get();
            return element.getAsObject();
        }
        return new HashMap<>();
    }

    public List<JsonElement> readArray() {
        Optional<JsonElement> optionalElement = readElement();
        if (optionalElement.isPresent()) {
            JsonElement element = optionalElement.get();
            return element.getAsArray();
        }
        return new ArrayList<>();
    }

    private Optional<JsonElement> readElement() {
        try {
            Reader reader = new BufferedReader(new FileReader(file.getPath()));
            JsonParser parser = new JsonParser();
            return Optional.of(new JsonElement(parser.parse(reader)));
        } catch (FileNotFoundException exception) {
            LOGGER.error("Could not parse CSV file \"" + file.getPath() + "\"");
        }
        return Optional.empty();
    }
}