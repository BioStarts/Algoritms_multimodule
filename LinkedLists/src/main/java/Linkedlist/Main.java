package Linkedlist;

/*
1. Реализовать все классы, рассмотренные в данном уроке.
2. В методе main LinkIteratorApp проверить все методы итератора.
3*. реализовать forEach для связанного списка
*/

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);

        linkedList.remove(3);
        linkedList.remove(333);

        linkedList.display();

        linkedList.remove();
        System.out.println("Find 2 " + linkedList.find(2));
        System.out.println("Find 5 " + linkedList.find(5));

    }
}
