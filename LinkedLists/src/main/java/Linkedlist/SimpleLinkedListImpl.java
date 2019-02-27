package Linkedlist;


import java.util.*;
import java.util.function.Consumer;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int currentSize;

    //transient Object[] elementData;


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

    /// удалить ниже и имплементс итерабле в линкдлист интерфейсе в случае краха  + elementData удалить вверху страницы

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        Object current;

        //int expectedModCount = 0;

        Itr() {
        }

        /*public boolean hasNext() {
            return cursor != currentSize;
        }*/

        public boolean hasNext() {
            return cursor < currentSize;
        }

        @SuppressWarnings("unchecked")
        public E next() {

            /*if (!hasNext()){
                throw new NoSuchElementException();
            }

            int i = lastRet;

            while (i < cursor) {
                if (current == null){
                    current = firstElement;
                    i++;
                    break;
                }

                current =  current;
                i++;

            }

            lastRet = i;
            cursor = i+1;
            return (E) current;*/

            if (isEmpty())
                return null;


            Entry<E> removeElement = firstElement;
            SimpleLinkedListImpl<E> newS = new SimpleLinkedListImpl<>();
            newS.insert(firstElement.getvalue());
            firstElement = firstElement.getNext();
            currentSize--;

            /*if (isEmpty()) {
                SimpleLinkedListImpl.this = newS;
            }*/

            return removeElement.getvalue();
        }

    }
}


