import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    public Node<E> rootNode;


    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (isEmpty()) {  // если дерево пустое, то приравниваем вершину добавляемому значению
            rootNode = newNode;
            return;
        }

        Node<E> current = rootNode;
        Node<E> previous = null;
        while ( current!= null){
            previous = current;

            if ( current.getValue().equals(value) ){
                return;
            }

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

        //Поиск удаляемого элемента и его родителя
        Node<E> current = rootNode;
        Node<E> parent = null;
        while ( current!= null){

            if ( current.getValue().equals(value) ){
                break;
            }
            parent = current;

            if ( current.shouldLeftChild(value)) { //идем искать в левую часть (меньшую)
                current = current.getLeftChild();
            }
            else {
                current = current.getRightChild(); // идем искать в правую часть (большую)
            }
        }

        if ( current == null ) {//Нет удаляемого элемента
            return false;
        }

        /** когда нет детей у удаляемого узла **/

        if (isLeaf(current)){
            if ( current == rootNode ){
                rootNode = null;
            }
            else if (parent.getLeftChild().equals(current)){
                parent.setLeftChild(null);
            }
            else {
                parent.setRightChild(null);
            }
        }

        /** когда один ребенок у удаляемого узла **/

        else if (hasOnlySingleChildElement(current)){
            Node<E> childNode = current.getLeftChild() != null
                    ? current.getLeftChild()
                    : current.getRightChild();

            if ( current == rootNode ){
                rootNode = childNode;
            }
            else if (parent.getLeftChild().equals(current)){
                parent.setLeftChild(childNode);
            }
            else {
                parent.setRightChild(childNode);
            }
        }

        /** когда 2 ребенка у удаляемого узла **/

        else {
            Node<E> successor = getSuccessor(current);
            if (current == rootNode){
                rootNode = successor;
            }
            else if (parent.getLeftChild().equals(current)){
                parent.setLeftChild(successor);
            }
            else  {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }


        return false;
    }


    private Node<E> getSuccessor(Node<E> removedNode){
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if ( successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());// Не забываем о правых потомках нашего кандидата н азамену
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;
    }

    private boolean hasOnlySingleChildElement(Node<E> current) {
        return current.getLeftChild() == null || current.getRightChild() == null;
    }

    private boolean isLeaf(Node<E> current) {
        return current.getLeftChild() == null && current.getRightChild() == null;
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

    /****/
    public int findForLevel(E value) { // весьма не эффективный метод для поиска уровня элемента, но подходит для нашей задачи

        Node<E> current = rootNode;
        int io = 1;

        while ( current!= null){
            if ( current.getValue().equals(value) ){ // true если текущий элемент
                return io;
            }
            if (current.shouldLeftChild(value)){ //идем искать в левую часть (меньшую)
                current = current.getLeftChild();
                io++;
            }
            else {
                current = current.getRightChild(); // идем искать в правую часть (большую)
                io++;
            }
        }
        return io;

    }

    public void display() {
        Stack<Node> globalStack = new Stack();
        globalStack.push(rootNode);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    public boolean isEmpty() {
        return rootNode == null;
    }

    public void traverse(TraverseMode traverseMode) {
        switch (traverseMode){
            case IN_ORDER:
                inOrder(rootNode);
                break;
            case PRE_ORDER:
                preOrder(rootNode);
                break;
            case POST_ORDER:
                postOrder(rootNode);
                break;
                default:
                    throw new IllegalArgumentException("Unknown traverse mode " + traverseMode);
        }
    }

    private void inOrder(Node<E> node){
        if( node == null )
            return;

        inOrder(node.getLeftChild());
        System.out.println(node);
        inOrder(node.getRightChild());
    }

    private void preOrder(Node<E> node){
        if( node == null )
            return;

        System.out.println(node);
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    private void postOrder(Node<E> node){
        if( node == null )
            return;

        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.println(node);
    }

    public boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    public int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

}
