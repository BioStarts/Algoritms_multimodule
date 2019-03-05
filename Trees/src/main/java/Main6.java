public class Main6 {

    public static void main(String[] args) {

        Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(25);
        tree.add(66);
        tree.add(15);
        tree.add(5);
        tree.add(20);
        tree.add(45);
        tree.add(30);
        tree.add(32);
        tree.add(55);

        /*tree.display();
        tree.remove(45);
        System.out.println(tree.find(55));
        System.out.println(tree.find(555));
        tree.display();
        System.out.println(((TreeImpl<Integer>) tree).findForLevel(32));*/

        newRanTree();
        newRanTree();
        newRanTree();
        newRanTree();
        newRanTree();
        newRanTree();

    }

    public static void newRanTree(){
        Tree<Integer> treeRand = new TreeImpl<>();
        int a = -20;
        int b =  40;
        int root;
        for (int i = 0; i < 20; i++) {
            int random_number = a + (int)(Math.random() * b);
            if ( ((TreeImpl<Integer>) treeRand).findForLevel(random_number) == 5 ){
                break;
                //treeRand.remove(random_number);
            }
            if ( i == 0){
                root = random_number;
            }
            treeRand.add(random_number);
        }
        //treeRand.display();
        System.out.println(((TreeImpl<Integer>) treeRand).isBalanced(((TreeImpl<Integer>) treeRand).rootNode));
        System.out.println(((TreeImpl<Integer>) treeRand).height(((TreeImpl<Integer>) treeRand).rootNode));
        System.out.println("----------------Next-----------------");
    }
}
