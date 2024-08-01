package threadcreation;

public class ThreadTester {

    public static void main(String[] args) {

        System.out.println("Main Starts");

        // Not preferred to extend thread class
        Thread threadExtendsThreadClass = new ThreadExtendsThreadClass("threadExtendsThreadClass");
        // threadExtendsThreadClass.setDaemon(true);
        threadExtendsThreadClass.start();


        Thread threadImplementsRunnable = new Thread(new ThreadImplementsRunnable(), "threadImplementsRunnable");
        threadImplementsRunnable.start();

        Thread threadImplementsRunnableWithLambda = new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("inside " + Thread.currentThread()  + " implementing runnable interface : " + i);
            }
        }, "threadImplementsRunnableWithLambda");
        threadImplementsRunnableWithLambda.start();

        System.out.println("Main Exit");
    }
}
