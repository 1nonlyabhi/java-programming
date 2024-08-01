package threadcreation;

public class ThreadExtendsThreadClass extends Thread {

    ThreadExtendsThreadClass(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("inside " + Thread.currentThread()  + " extending thread class : " + i);
        }
    }
}
