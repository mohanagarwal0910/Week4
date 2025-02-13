package com.capgeminitrainingday2;
import java.util.Arrays;
import java.util.List;
public class RotateElement {
    public static <T> void rotate(List<T> list, int k) {
        int n = list.size();
        if (n == 0) {
            return;
        }
        
        // Step 1: Reverse the first k elements
        reverse(list, 0, k - 1);
        // Step 2: Reverse the remaining elements
        reverse(list, k, n - 1);
        // Step 3: Reverse the entire list
        reverse(list, 0, n - 1);
    }
    private static <T> void reverse(List<T> list, int start, int end) {
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(10,20,30,40,50);
        //list before rotating
        System.out.println(list);
        int position=2;
        rotate(list,position);
        //list after rotating
        System.out.println(list);
    }
}
