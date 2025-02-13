package com.capgeminitrainingday2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class FrequencyCounter {
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        // Count the frequency of each element
        Map<String,Integer> result = countFrequency(fruits);
        // Print the result
        System.out.println(result);
    }
}
