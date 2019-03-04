public interface Tree<E extends Comparable<? super E>> {

    void add(E value);

    boolean remove(E value);

    boolean find(E value);

    void display();

    boolean isEmpty();

}
