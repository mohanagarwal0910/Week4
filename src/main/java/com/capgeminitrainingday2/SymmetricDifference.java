package com.capgeminitrainingday2;
import java.util.*;
public class SymmetricDifference {
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> symmetricDiffSet = new HashSet<>(set1);
        symmetricDiffSet.addAll(set2);
        Set<Integer> intersectionSet = intersection(set1, set2);
        symmetricDiffSet.removeAll(intersectionSet);
        return symmetricDiffSet;
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
    }
}
