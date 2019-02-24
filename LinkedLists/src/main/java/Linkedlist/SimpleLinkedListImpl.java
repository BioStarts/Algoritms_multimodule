package Linkedlist;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int currentSize;


    public void insert(E value) {
        Entry<E> newElement = new Entry<>(value);
        newElement.setNext(firstElement);
        firstElement = newElement;
        currentSize++;
    }

    public E remove() {
        if (isEmpty())
            return null;

        Entry<E> removeElement = firstElement;
        firstElement = firstElement.getNext();
        currentSize--;

        return removeElement.getvalue();
    }

    @Override
    public boolean remove(E value) {
        Entry<E> current = firstElement;
        Entry<E> previous = null;

        while ( current != null ) {
            if (current.getvalue().equals(value)) {break;}
            previous = current;
            current = current.getNext();
        }

        if (current == null){
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.getNext();
        } else {
            previous.setNext(current.getNext());
        }

        currentSize--;
        return true;
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public int getSize() {
        return currentSize;
    }

    public boolean find(E value) {
        Entry<E> current = firstElement;
        while ( current != null ) {
            if (current.getvalue().equals(value)) {return true;}
            current = current.getNext();
        }
        return false;
    }

    public void display() {
        System.out.println("-------");
        System.out.println("display " + this.getClass().getSimpleName());

        Entry<E> current = firstElement;
        while ( current != null ) {
            System.out.println(current);
            current = current.getNext();
        }
        System.out.println("-------");
    }

    @Override
    public E getFirstElement() {
        return firstElement.getvalue();
    }

    @Override
    public Entry<E> getFirst() {
        return firstElement;
    }
}
