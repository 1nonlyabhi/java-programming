package threads.example;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(final int bufferSize){
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(final int item) {
        while (bufferSize == sharedBuffer.size()) {
            System.out.println("Buffer is full, producer is waiting for consumer.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sharedBuffer.add(item);
        System.out.println("Produced : " + item);
        notify();
    }

    public synchronized int consume() {
        while (sharedBuffer.isEmpty()) {
            System.out.println("Buffer is empty, consumer is waiting for producer.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int item = sharedBuffer.poll();
        System.out.println("Produced : " + item);
        notify();
        return item;
    }

}
