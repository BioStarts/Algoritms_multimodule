package iterator;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkInterator itr = new LinkInterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        list.display();

        System.out.println("--------Тест insertAfter и insertBefore---------");

        itr.insertAfter("Zord", 22);
        itr.insertBefore("Ammi", 11);
        list.display();

        System.out.println("--------Тест atEnd()---------");

        LinkedList list2 = new LinkedList();
        LinkInterator itr2 = new LinkInterator(list2);
        itr2.insertBefore("Lola", 18);
        System.out.println("atEnd() = " + itr2.atEnd());

        System.out.println("--------Тест getCurrent()---------");

        System.out.println("getCurrent() = " + itr2.getCurrent().name);
        itr2.insertBefore("Masha", 19);
        System.out.println("getCurrent() = " + itr2.getCurrent().name);

        System.out.println("--------Тест deleteCurrent()---------");
        System.out.println("Delete : " + itr2.getCurrent().name);
        itr2.deleteCurrent();
        System.out.println("getCurrent() = " + itr2.getCurrent().name);



    }

}
