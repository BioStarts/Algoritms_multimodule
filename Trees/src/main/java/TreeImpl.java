public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> rootNode;


    public void add(E value) {
        Node<E> newNode = new Node<E>(value);
        if (isEmpty()) {  // если дерево пустое, то приравниваем вершину добавляемому значению
            rootNode = newNode;
            return;
        }

        Node<E> current = rootNode;
        Node<E> previous = null;
        while ( current!= null){
            previous = current;
            if ( current.shouldLeftChild(value)) { //идем искать в левую часть (меньшую)
                current = current.getLeftChild();
            }
            else {
                current = current.getRightChild(); // идем искать в правую часть (большую)
            }
        }
        if (previous.shouldLeftChild(value)){ // если меньше родителя то кладем в левую ссылку
            previous.setLeftChild(newNode);
        }
        else {
            previous.setRightChild(newNode); // если больше то в парвую
        }

    }

    public boolean remove(E value) {
        return false;
    }

    public boolean find(E value) {

        Node<E> current = rootNode;
        while ( current!= null){
            if ( current.getValue().equals(value) ){ // true если текущий элемент
                return true;
            }
            if (current.shouldLeftChild(value)){ //идем искать в левую часть (меньшую)
                current = current.getLeftChild();
            }
            else {
                current = current.getRightChild(); // идем искать в правую часть (большую)
            }
        }
        return false;

    }

    public void display() {

    }

    public boolean isEmpty() {
        return rootNode == null;
    }
}
