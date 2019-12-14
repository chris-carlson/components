package cac.components.io.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonElement {
    private com.google.gson.JsonElement element;

    public JsonElement(com.google.gson.JsonElement element) {
        this.element = element;
    }

    public Map<String, JsonElement> getAsObject() {
        Map<String, JsonElement> pairs = new HashMap<>();
        JsonObject object = element.getAsJsonObject();
        for (Map.Entry<String, com.google.gson.JsonElement> pair : object.entrySet()) {
            pairs.put(pair.getKey(), new JsonElement(pair.getValue()));
        }
        return pairs;
    }

    public List<JsonElement> getAsArray() {
        List<JsonElement> elements = new ArrayList<>();
        JsonArray array = element.getAsJsonArray();
        for (com.google.gson.JsonElement item : array) {
            elements.add(new JsonElement(item));
        }
        return elements;
    }

    public String getAsString() {
        return element.getAsString();
    }

    public int getAsInt() {
        return element.getAsInt();
    }

    public float getAsFloat() {
        return element.getAsFloat();
    }

    public boolean getAsBoolean() {
        return element.getAsBoolean();
    }
}
