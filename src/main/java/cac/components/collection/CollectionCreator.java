package cac.components.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionCreator {
    @SafeVarargs
    public static <E> List<E> createList(E... elements) {
        return new ArrayList<>(List.of(elements));
    }

    @SafeVarargs
    public static <E> Set<E> createSet(E... elements) {
        return new HashSet<>(Set.of(elements));
    }

    @SafeVarargs
    public static <K, V> Map<K, V> createMap(Map.Entry<? extends K, ? extends V>... elements) {
        return new HashMap<>(Map.ofEntries(elements));
    }

    private CollectionCreator() {
    }
}
