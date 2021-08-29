package cac.components.collection;

import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.Map;

public class Graph<T> {
    private final ShortestPathAlgorithm<T, DefaultWeightedEdge> algorithm;

    public Graph(Map<T, Map<T, Integer>> map) {
        org.jgrapht.Graph<T, DefaultWeightedEdge> rep = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        for (T vertex : map.keySet()) {
            rep.addVertex(vertex);
        }
        for (Map.Entry<T, Map<T, Integer>> element : map.entrySet()) {
            for (Map.Entry<T, Integer> connection : element.getValue().entrySet()) {
                DefaultWeightedEdge edge = rep.addEdge(element.getKey(), connection.getKey());
                rep.setEdgeWeight(edge, connection.getValue());
            }
        }
        algorithm = new DijkstraShortestPath<>(rep);
    }

    public int getDistance(T source, T destination) {
        return (int) algorithm.getPathWeight(source, destination);
    }
}
