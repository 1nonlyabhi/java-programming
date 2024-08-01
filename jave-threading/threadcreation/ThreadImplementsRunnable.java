package threadcreation;

public class ThreadImplementsRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("inside " + Thread.currentThread()  + " implementing runnable interface : " + i);
        }
    }
}
