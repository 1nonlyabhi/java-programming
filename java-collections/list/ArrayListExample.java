package list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListExample {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(0, 100);
        list.add(1, 200);
        list.add(2, 300);

        List<Integer> newList = new ArrayList<>();
        newList.add(0, 400);
        newList.add(1, 500);
        newList.add(2, 600);

        list.addAll(2, newList);
        list.forEach(System.out::println);

        // replaceAll Urinary Operator
        list.replaceAll(val -> -1 * val);
        System.out.println("after replaceAll method");
        list.add(2, 456);
        list.forEach(System.out::println);

        // traversing forward direction
        ListIterator<Integer> listIterator = list.listIterator();
        System.out.println("traversing forward: " + listIterator.hasPrevious() + " nextIndex: " + listIterator.nextIndex() + " prevIndex: " + listIterator.previousIndex());
        while(listIterator.hasNext()){
            int val = listIterator.next();
            System.out.println("traversing forward: " + val + " nextIndex: " + listIterator.nextIndex() + " prevIndex: " + listIterator.previousIndex());
            if (val == -200) {
                listIterator.add(-900);
            }
        }
        //  listIterator.forEachRemaining(System.out::println);

        System.out.println("now list look something like this");
        list.forEach(val -> System.out.print(val + " "));
        System.out.println();

        // traversing backward
        ListIterator<Integer> newListIterator = list.listIterator(list.size());
        System.out.println("traversing forward: " + newListIterator.hasNext() + " nextIndex: " + newListIterator.nextIndex() + " prevIndex: " + newListIterator.previousIndex());
        while(newListIterator.hasPrevious()) {
            int val = newListIterator.previous();
            System.out.println("traversing backward: " + val + " nextIndex: " + newListIterator.nextIndex() + " prevIndex: " + newListIterator.previousIndex());
            if (val == -900) {
                newListIterator.add(-450);
            }
        }
        System.out.println("now list look something like this");
        list.forEach(val -> System.out.print(val + " "));
        System.out.println();

    }
}
