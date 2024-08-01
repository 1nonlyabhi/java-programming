package countdown;

import java.time.LocalDateTime;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownTest {

    public static void main(String[] args) throws InterruptedException {

        int threadCount = 100;
        CountDownLatch endLatch = new CountDownLatch(threadCount);
        CyclicBarrier startBarrier = new CyclicBarrier(threadCount);

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println("Thread ready: " + LocalDateTime.now());
                    startBarrier.await(); // Ensure all threads are ready to start
                    System.out.println("Method invoked at: " + LocalDateTime.now());

                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // Signal that this thread is done
                    endLatch.countDown();
                }
            });
        }

        endLatch.await(10, TimeUnit.SECONDS);

        // Shutdown executor service
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        // Verify the method invocation counts
        // Use atLeast and atMost to validate

    }
}
