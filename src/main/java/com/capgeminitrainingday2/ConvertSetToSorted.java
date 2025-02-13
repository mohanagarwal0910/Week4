package com.capgeminitrainingday2;
import java.util.*;
public class ConvertSetToSorted {
    public static List<Integer> convert(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9,1));
        System.out.println(convert(set));
    }
}
