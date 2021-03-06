package iterator;


import Linkedlist.LinkedList;
import Linkedlist.SimpleLinkedListImpl;

public class TestIterator {

    public static void main(String[] args) {
        int[] intArray = {1,2,3};
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

        System.out.println("------------");

        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);

        for (Integer element: linkedList
             ) {
            System.out.println("лол: " +  element);
        }

        System.out.println("------2попытка------");

        for (Integer element: linkedList
        ) {
            System.out.println("лол: " +  element);
        }

        System.out.println("------3------");

        ListIterator<Integer> iterator = (ListIterator) linkedList.iterator();
        iterator.reset();
        iterator.insertAfter(11);
        iterator.next();
        iterator.remove();
        iterator.insertBefore(0);

        while (iterator.hasNext()){
            Integer next = iterator.next();
        }

        displayAll(linkedList);

    }

    private static void displayAll (LinkedList<Integer> list){
        for (Integer value: list
             ) {
            System.out.println(value);
        }
    }
}
