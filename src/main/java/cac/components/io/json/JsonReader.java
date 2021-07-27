package cac.components.io.json;

import cac.components.path.File;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        try (Reader reader = new BufferedReader(new FileReader(file.getPath()))) {
            JsonParser parser = new JsonParser();
            return Optional.of(new JsonElement(parser.parse(reader)));
        } catch (IOException exception) {
            LOGGER.error(MessageFormat.format("Could not parse CSV file \"{0}\"", file.getPath()));
        }
        return Optional.empty();
    }
}
