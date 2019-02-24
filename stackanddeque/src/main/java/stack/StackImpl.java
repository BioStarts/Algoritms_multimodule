package stack;

public class StackImpl<E> implements Stack<E> {

    private E[] data;
    private  int size;

    public StackImpl (int maxSize){
        this.data = (E[]) new Object[maxSize];
        this.size = 0;
    }

    public void push(E value) {
        this.data[size++] = value;
    }

    public E pop() {
        return data[--size];
    }

    public E peek() {
        return data[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
