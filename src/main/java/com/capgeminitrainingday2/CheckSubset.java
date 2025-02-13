    package com.capgeminitrainingday2;
    import java.util.*;
    public class CheckSubset {
        public static boolean isSubset(Set<Integer> subset, Set<Integer> superset) {
            return superset.containsAll(subset);
        }
        public static void main(String[] args) {
            Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
            Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
            System.out.println("Is Set1 a subset of Set2? " + isSubset(set1, set2));
        }
    }
