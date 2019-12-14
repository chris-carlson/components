package cac.components.collection;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder {
    @SafeVarargs
    public static <K, V> Map<K, V> buildMap(Map.Entry<K, V>... entries) {
        return new HashMap<>(Map.ofEntries(entries));
    }
}
