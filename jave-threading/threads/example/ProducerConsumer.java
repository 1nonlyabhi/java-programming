package threads.example;

public class ProducerConsumer {
    public static void main(String[] args) {

        SharedResource sharedBuffer = new SharedResource(4);
        
        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sharedBuffer.produce(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sharedBuffer.consume();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
