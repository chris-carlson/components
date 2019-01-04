package com.cac.components.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayCreator {
    public static Array<Integer> create(String rep) {
        List<Integer> list = new ArrayList<>();
        String[] elements = rep.split(",");
        for (String element : elements) {
            list.add(Integer.parseInt(element));
        }
        return new Array<>(list);
    }
}
