package cac.components.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class GraphTest {
    @Test
    void getAdjacentDistance() {
        Graph<String> graph = new Graph<>(
                CollectionCreator.createMap(Map.entry("a", CollectionCreator.createMap(Map.entry("b", 3))),
                        Map.entry("b", CollectionCreator.createMap())));
        Assertions.assertEquals(3, graph.getDistance("a", "b"));
    }

    @Test
    void getNonadjacentDistance() {
        Graph<String> graph = new Graph<>(
                CollectionCreator.createMap(Map.entry("a", CollectionCreator.createMap(Map.entry("b", 3))),
                        Map.entry("b", CollectionCreator.createMap(Map.entry("c", 4))),
                        Map.entry("c", CollectionCreator.createMap())));
        Assertions.assertEquals(7, graph.getDistance("a", "c"));
    }

    @Test
    void getShortestDistance() {
        Graph<String> graph = new Graph<>(CollectionCreator.createMap(
                Map.entry("a", CollectionCreator.createMap(Map.entry("b", 3), Map.entry("c", 4))),
                Map.entry("b", CollectionCreator.createMap(Map.entry("d", 4))),
                Map.entry("c", CollectionCreator.createMap(Map.entry("d", 4))),
                Map.entry("d", CollectionCreator.createMap())));
        Assertions.assertEquals(7, graph.getDistance("a", "d"));
    }
}
