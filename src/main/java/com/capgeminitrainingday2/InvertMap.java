package com.capgeminitrainingday2;
import java.util.*;
public class InvertMap {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> inverted = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            // Check if the value already exists in the map, if not, create a new list
            if (!inverted.containsKey(value)) {
                inverted.put(value, new ArrayList<>());
            }
            // Add the key to the list
            inverted.get(value).add(key);
        }
        return inverted;
    }
    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);
        System.out.println(invertMap(inputMap));
    }
}

