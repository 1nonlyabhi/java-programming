package threads.producer_consumer;

import java.util.ArrayDeque;

public class FixedQueueResource {

    int queueCapacity = 10;
    int itemCount = 0;
    boolean flagProducer = false;
    boolean flagConsumer = false;

    ArrayDeque<Integer> arrayDequeAsQueue = new ArrayDeque<>();

    public synchronized void produceItem(int item) {
        if(arrayDequeAsQueue.size() < queueCapacity) {
            arrayDequeAsQueue.addLast(item);
            System.out.println("Produced : " + item);
            itemCount++;
            notifyAll();
        } else {
            flagProducer = false;
            while (!flagProducer) {
                try {
                    flagConsumer = true;
                    notifyAll();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void consumeItem() {
        if(arrayDequeAsQueue.size() > 0) {
            arrayDequeAsQueue.removeFirst();
            System.out.println("Consumed");
            itemCount--;
            notifyAll();
        } else {
            flagConsumer = false;
            while (!flagConsumer) {
                try {
                    flagProducer = true;
                    notifyAll();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}