public class Node<E extends Comparable<? super E>> {

    private E value;

    private Node<E> leftChild;
    private Node<E> rightChild;

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }


    public Node<E> getLeftChild() {
        return leftChild;
    }

    public Node<E> getRightChild() {
        return rightChild;
    }


    public void setLeftChild(Node<E> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<E> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean shouldLeftChild(E value) {
        if ( value.compareTo(getValue()) < 0){
            return true;
        }
        else {
            return false;
        }
    }
}
