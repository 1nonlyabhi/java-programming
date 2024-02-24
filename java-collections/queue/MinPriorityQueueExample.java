package queue;

import java.util.PriorityQueue;

public class MinPriorityQueueExample {

    public static void main(final String[] args){
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        minPQ.add(5);
        minPQ.add(2);
        minPQ.add(8);
        minPQ.add(1);

        // Also be implement as this: minPQ.forEach((Integer val) -> System.out.println(val));
        minPQ.forEach(System.out::println);

        // remove top element
        while (!minPQ.isEmpty()) {
            int val = minPQ.remove();
            System.out.println("remove from top " + val);
        }
    }
}
