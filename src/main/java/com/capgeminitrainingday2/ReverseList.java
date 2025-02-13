package com.capgeminitrainingday2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ReverseList {
    public static <T> void reverseList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            // Swap elements at left and right indices
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList();
        LinkedList<Integer> list2=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list2.addAll(list);
        //List before reversing
        System.out.println(list);
        System.out.println(list2);
        reverseList(list);
        reverseList(list2);
        //List after reversing
        System.out.println(list);
        System.out.println(list2);
    }
}
