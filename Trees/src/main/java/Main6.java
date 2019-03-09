import java.util.Comparator;
import java.util.TreeSet;

public class Main6 {

    public static int balanceTree = 0;

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


        //Создаю 20 рандомных деревьев
        for (int i = 0; i < 20; i++) {
            newRanTree();
        }
        System.out.println("Из 20 деревьев сбалансированно " + balanceTree);


        System.out.println();
        System.out.println("Стандартная java реализация treeSet коллекции с заранее определеннем в классе Person интерфейсом comparable: ");
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person(5,"Oleg"));
        treeSet.add(new Person(3,"Oleg"));
        treeSet.add(new Person(9,"Oleg"));
        treeSet.add(new Person(2,"Oleg"));

        for (Person person : treeSet) {
            System.out.println(person);
        }

    }

    public static void newRanTree(){
        Tree<Integer> treeRand = new TreeImpl<>();
        int a = -20;
        int b =  40;
        for (int i = 0; i < 20; i++) {
            int random_number = a + (int)(Math.random() * b);
            if ( ((TreeImpl<Integer>) treeRand).findForLevel(random_number) == 5 ){ // если уровень вложенности в дерево = 5, то пропускаем итерацию
                break;
            }
            treeRand.add(random_number);
        }
        //treeRand.display();
        //System.out.println(((TreeImpl<Integer>) treeRand).isBalanced(((TreeImpl<Integer>) treeRand).rootNode));
        System.out.println("Глубина дерева = " + ((TreeImpl<Integer>) treeRand).height(((TreeImpl<Integer>) treeRand).rootNode));
        if (((TreeImpl<Integer>) treeRand).isBalanced(((TreeImpl<Integer>) treeRand).rootNode)){ // инкрементирую счетчик если дерево сбалансированно
            balanceTree++;
        }
        System.out.println("----------------Next-----------------");
    }
}
