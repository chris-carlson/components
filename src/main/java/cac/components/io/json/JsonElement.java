package cac.components.io.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode
public class JsonElement {
    private com.google.gson.JsonElement rep;

    public JsonElement(com.google.gson.JsonElement rep) {
        this.rep = rep;
    }

    public JsonElement(Map<String, JsonElement> map) {
        JsonObject object = new JsonObject();
        for (Map.Entry<String, JsonElement> pair : map.entrySet()) {
            object.add(pair.getKey(), pair.getValue().getRep());
        }
        rep = object;
    }

    public JsonElement(List<JsonElement> list) {
        JsonArray array = new JsonArray();
        for (JsonElement element : list) {
            array.add(element.getRep());
        }
        rep = array;
    }

    public JsonElement(boolean primitive) {
        rep = new JsonPrimitive(primitive);
    }

    public JsonElement(int primitive) {
        rep = new JsonPrimitive(primitive);
    }

    public JsonElement(float primitive) {
        rep = new JsonPrimitive(primitive);
    }

    public JsonElement(String primitive) {
        rep = new JsonPrimitive(primitive);
    }

    com.google.gson.JsonElement getRep() {
        return rep;
    }

    boolean isObject() {
        return rep.isJsonObject();
    }

    boolean isArray() {
        return rep.isJsonArray();
    }

    boolean isBoolean() {
        if (rep.isJsonPrimitive()) {
            JsonPrimitive primitive = rep.getAsJsonPrimitive();
            return primitive.isBoolean();
        }
        return false;
    }

    boolean isNumber() {
        if (rep.isJsonPrimitive()) {
            JsonPrimitive primitive = rep.getAsJsonPrimitive();
            return primitive.isNumber();
        }
        return false;
    }

    boolean isString() {
        if (rep.isJsonPrimitive()) {
            JsonPrimitive primitive = rep.getAsJsonPrimitive();
            return primitive.isString();
        }
        return false;
    }

    public Map<String, JsonElement> getAsObject() {
        Map<String, JsonElement> pairs = new HashMap<>();
        JsonObject object = rep.getAsJsonObject();
        for (Map.Entry<String, com.google.gson.JsonElement> pair : object.entrySet()) {
            pairs.put(pair.getKey(), new JsonElement(pair.getValue()));
        }
        return pairs;
    }

    public List<JsonElement> getAsArray() {
        List<JsonElement> elements = new ArrayList<>();
        JsonArray array = rep.getAsJsonArray();
        for (com.google.gson.JsonElement item : array) {
            elements.add(new JsonElement(item));
        }
        return elements;
    }

    public String getAsString() {
        return rep.getAsString();
    }

    public int getAsInt() {
        return rep.getAsInt();
    }

    public float getAsFloat() {
        return rep.getAsFloat();
    }

    public boolean getAsBoolean() {
        return rep.getAsBoolean();
    }
}
