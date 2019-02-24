package Linkedlist;

import java.util.Objects;

public class Entry<E> {

    private final  E value;
    private Entry<E> next;

    public Entry(E value) {
        this.value = value;
    }


    public E getvalue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry<?> Entry = (Entry<?>) o;
        return Objects.equals(value, Entry.value);
    }


    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "value=" + value +
                '}';
    }


    public Entry<E> getNext() {
        return next;
    }

    public void setNext(Entry<E> next) {
        this.next = next;
    }
}
