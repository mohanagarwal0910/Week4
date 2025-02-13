package com.capgeminitrainingday2;
import java.util.*;
public class ReverseQueue {
    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int front = queue.poll();
        reverse(queue);
        queue.add(front);
    }
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("Original queue: " + queue);
        reverse(queue);
        System.out.println(queue);
    }
}
