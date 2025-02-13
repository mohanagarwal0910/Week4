package com.capgeminitrainingday2;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
public class MaxValueKeyFinder {
    public static String findMaxKey(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        System.out.println(findMaxKey(map));
    }
}
