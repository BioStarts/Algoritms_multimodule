package Linkedlist;


import iterator.ListIterator;

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
        return new LinkedListIterator<E>(this);
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }



    private static class LinkedListIterator<E> implements ListIterator<E> {

        private SimpleLinkedListImpl list;

        private Entry<E> current;
        private Entry<E> previous;

        public LinkedListIterator(SimpleLinkedListImpl<E> list) {
            this.list = list;
            reset();
        }


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E nextValue = current.getvalue();
            previous = current;
            current = current.getNext();
            return nextValue;
        }

        @Override
        public void remove() {
            if (previous == null){
                list.firstElement = current.getNext();
                reset();
            } else {
                previous.setNext(current.getNext());
                if ( !hasNext() ) {
                    reset();
                } else {
                    current = current.getNext();
                }
            }
        }

        @Override
        public void reset() {
            current = list.firstElement;
            previous = null;
        }

        @Override
        public void insertBefore(E value) {
            Entry newItem = new Entry(value);
            if(previous == null){
                newItem.setNext(list.firstElement);
                list.firstElement = newItem;
                reset();
            } else {
                newItem.setNext(previous.getNext());
                previous.setNext(newItem);
                current = newItem;
            }
        }

        @Override
        public void insertAfter(E value) {
            Entry newItem = new Entry(value);
            if(list.isEmpty()){
                list.firstElement = newItem;
                current = newItem;
            } else {
                newItem.setNext(current.getNext());
                current.setNext(newItem);
                next();
            }
        }
    }
}


