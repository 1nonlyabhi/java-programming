package queue;

import java.util.PriorityQueue;

public class MaxPriorityQueueExample {

    public static void main(final String[] args) {

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((Integer v1, Integer v2) -> v2-v1);
        maxPQ.add(5);
        maxPQ.add(8);
        maxPQ.add(2);
        maxPQ.add(1);

        maxPQ.forEach((Integer value) -> System.out.println(value));

        while(!maxPQ.isEmpty()) {
            int val = maxPQ.poll();
            System.out.println("last element removed " + val);
        }
    }
}
