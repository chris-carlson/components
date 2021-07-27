package cac.components.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class MapBuilderTest {
    @Test
    void buildEmptyMap() {
        Assertions.assertEquals(new HashMap<>(), MapBuilder.buildMap());
    }

    @Test
    void buildNonEmptyMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("foo", 1);
        map.put("bar", 2);
        map.put("baz", 3);
        Assertions.assertEquals(map,
                MapBuilder.buildMap(Map.entry("foo", 1), Map.entry("bar", 2), Map.entry("baz", 3)));
    }
}
