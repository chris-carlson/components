package cac.components.io.json;

import cac.components.path.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class JsonWriter {
    private static final Logger LOGGER = LogManager.getLogger();

    private File file;
    private com.google.gson.stream.JsonWriter writer;

    public JsonWriter(File file) {
        this.file = file;
        writer = createWriter();
    }

    public void writeObject(Map<String, JsonElement> object) {
        try {
            writer.beginObject();
            for (Map.Entry<String, JsonElement> pair : object.entrySet()) {
                writer.name(pair.getKey());
                writeElement(pair.getValue());
            }
            writer.endObject();
        } catch (IOException exception) {
            LOGGER.error(MessageFormat.format("Could not write object to file \"{0}\"", file.getPath()));
        }
    }

    public void writeArray(List<JsonElement> array) {
        try {
            writer.beginArray();
            for (JsonElement element : array) {
                writeElement(element);
            }
            writer.endArray();
        } catch (IOException exception) {
            LOGGER.error(MessageFormat.format("Could not write object to file \"{0}\"", file.getPath()));
        }
    }

    private void writePrimitive(JsonElement primitive) {
        try {
            if (primitive.isBoolean()) {
                writer.value(primitive.getAsBoolean());
            } else if (primitive.isNumber()) {
                writer.value(primitive.getAsInt());
            } else if (primitive.isString()) {
                writer.value(primitive.getAsString());
            }
        } catch (IOException exception) {
            LOGGER.error(MessageFormat.format("Could not write object to file \"{0}\"", file.getPath()));
        }
    }

    private void writeElement(JsonElement element) {
        if (element.isObject()) {
            writeObject(element.getAsObject());
        } else if (element.isArray()) {
            writeArray(element.getAsArray());
        } else {
            writePrimitive(element);
        }
    }

    private com.google.gson.stream.JsonWriter createWriter() {
        try {
            return new com.google.gson.stream.JsonWriter(new BufferedWriter(new FileWriter(file.getPath())));
        } catch (IOException exception) {
            LOGGER.error(MessageFormat.format("Could not write JSON file \"{0}\"", file.getPath()));
        }
        return null;
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException exception) {
            LOGGER.error(MessageFormat.format("Could not close JSON file \"{0}\"", file.getPath()));
        }
    }
}
