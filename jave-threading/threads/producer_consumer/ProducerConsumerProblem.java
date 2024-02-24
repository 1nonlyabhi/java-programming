package threads.producer_consumer;

public class ProducerConsumerProblem {

    

    public static void main(String[] args) {

        FixedQueueResource fixedQueueResource = new FixedQueueResource();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                fixedQueueResource.produceItem(i);
            }
            
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                fixedQueueResource.consumeItem();
            }
            
        });
        
        producerThread.start();
        consumerThread.start();

    }
}
