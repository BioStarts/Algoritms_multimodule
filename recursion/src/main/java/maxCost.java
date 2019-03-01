import java.util.ArrayList;
import java.util.ListIterator;

public class maxCost {

    static final int MAX_WEIGHT = 5;

    static int COUNT_STUFF;

    static ArrayList maxNext = new ArrayList();
    static int nRot = 0;

    public static void main(String[] args) {

        stuff lol = new stuff("Зонт", 1, 5); //создаем вещи
        stuff lol2 = new stuff("Часы", 2, 4);
        stuff lol3 = new stuff("Шарф", 1, 2);
        stuff lol4 = new stuff("Кольцо", 2, 3);

        stuff[] all = new stuff[4]; // добавляем в массив
        all[0] = lol;
        all[1] = lol2;
        all[2] = lol3;
        all[3] = lol4;

        COUNT_STUFF = all.length;

        ArrayList set = new ArrayList();

        for (int i = 0; i < all.length; i++) { //добавляем все вещи в список
            set.add(all[i]);
        }

        System.out.println("Самый дорогой набор вещей: ");
        display(goodSet(set));

    }

    public static ArrayList goodSet(ArrayList allSet) {

        if (setWeight(allSet) > MAX_WEIGHT) {
            return rotate(allSet); // если все вещи не вмещаеются в рюкзак начинаем рекурсию по поиску самого дорого набора
        }

        else return allSet;
    }

    private static ArrayList rotate(ArrayList nextSet) { // рекурсивный метод для поиска из n вещей (n-1) набора самых дорогих вещей

        if ((nRot == COUNT_STUFF) && (maxNext != null)) { //выходим из рекурсии когда количесвто обходов равно количесвту вещей
            return maxNext;
        }

        ArrayList copyNext = new ArrayList(); //создаем копию для последующего сдвига и передачи в рекурсию
        copyNext.addAll(nextSet);

        nRot = nRot + 1; // считаем количесво рекурсивных обходов

        nextSet.remove(0);//отсекаем первый элемент

        if (setWeight(nextSet) > MAX_WEIGHT) { //если вес текущего набора превышает допустимый делаем смещение и передаем в рекурсию
            shiftFirstByLast(copyNext);
            return rotate(copyNext);
        } else if (setCost(nextSet) > (setCost(maxNext))) { //в обратном случае проверям дороже ли этот набор текущего самого дорогого и если да перезаписываем
            // + делаем смещение и снова в рекурсию

            if (maxNext.size() == 0) { //если самый дорогой набор пустой складываем в него текущий (первый подходящий)
                maxNext.addAll(nextSet);
            }

            maxNext.clear(); //заменяем на более дорогой
            maxNext.addAll(nextSet);

            shiftFirstByLast(copyNext);

            return rotate(copyNext);
        }
        return rotate(copyNext);
    }

    private static void shiftFirstByLast(ArrayList anySet) { // делает сдвиг первого элемента на последний
        stuff save0;
        save0 = (stuff) anySet.remove(0);
        anySet.add(anySet.size(), save0);
    }


    public static void display(ArrayList allSet) { // выводит в консоль список вещей/набор
        ListIterator listIterator = allSet.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(((stuff) listIterator.next()).name);
        }
    }

    static Integer setWeight(ArrayList anySet) { // возвращает общий вес всех элементов набора
        ListIterator listIterator = anySet.listIterator();
        int sizeAll = 0;
        while (listIterator.hasNext()) {
            sizeAll = sizeAll + ((stuff) listIterator.next()).weight;
        }
        return sizeAll;
    }

    static Integer setCost(ArrayList anySet) { // возвращает общую стоимость всех элементов набора
        ListIterator listIterator = anySet.listIterator();
        int costAll = 0;
        while (listIterator.hasNext()) {
            costAll = costAll + ((stuff) listIterator.next()).cost;
        }
        return costAll;
    }


}
