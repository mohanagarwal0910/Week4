package com.capgeminitrainingday2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NthFromEnd {
    public static <T> Object findNthFromEnd(LinkedList<T>list,int n){
        if (list == null || n <= 0) return null;

        var first = list.listIterator();
        var second = list.listIterator();

        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) return null;
            first.next();
        }

        // Move both pointers until first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2;
        System.out.println(findNthFromEnd(list, N));

    }
}
