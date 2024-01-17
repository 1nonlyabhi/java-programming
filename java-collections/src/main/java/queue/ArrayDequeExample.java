package queue;

import java.util.ArrayDeque;

public class ArrayDequeExample {

    public static void main(String[] args) {

        ArrayDeque<Integer> arrayDequeAsQueue = new ArrayDeque<>();
        //Insertion
        arrayDequeAsQueue.addLast(4);
        arrayDequeAsQueue.addLast(8);
        arrayDequeAsQueue.addLast(1);
        //Deletion
        System.out.println(arrayDequeAsQueue.removeFirst());

        ArrayDeque<Integer> arrayDequeAsStack = new ArrayDeque<>();
        //Insertion
        arrayDequeAsStack.addFirst(4);
        arrayDequeAsStack.addFirst(8);
        arrayDequeAsStack.addFirst(1);
        //Deletion
        System.out.println(arrayDequeAsStack.removeFirst());

    }
}
