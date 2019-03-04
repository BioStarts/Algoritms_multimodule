import java.util.ArrayList;
import java.util.ListIterator;

public class MaxCostRefactoring {

    static final int MAX_WEIGHT = 3;

    static int COUNT_STUFF;

    static ArrayList<stuff> maxNext = new ArrayList();


    public static void main(String[] args) {

        stuff lol = new stuff("Зонт", 1, 5); //создаем вещи
        stuff lol2 = new stuff("Часы", 2, 4);
        stuff lol3 = new stuff("Шарф", 2, 7);
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


        goodSet(set);

        display(maxNext);

    }



    public static void goodSet(ArrayList allSet) {

        if (setWeight(allSet) > MAX_WEIGHT) {
            rotate(allSet); // если все вещи не вмещаеются в рюкзак начинаем рекурсию по поиску самого дорого набора
        }

        else maxNext.addAll(allSet); // в обратном случае сразу складываем все вещи в рюкзак
    }


    private static void rotate(ArrayList nextSet) { // рекурсивный метод для перебора всех вариантов наборов

        if ((setWeight(nextSet) <= MAX_WEIGHT) & (setCost(nextSet) > setCost(maxNext))) { //в обратном случае проверям дороже ли этот набор текущего самого дорогого и если да перезаписываем
            // + делаем смещение и снова в рекурсию

            if (maxNext.size() == 0) { //если самый дорогой набор пустой складываем в него текущий (первый подходящий)
                maxNext.addAll(nextSet);
            }

            maxNext.clear(); //заменяем на более дорогой
            maxNext.addAll(nextSet);}

        for (int i = 0; i < nextSet.size(); i++) {
            ArrayList copyNext = new ArrayList(); //создаем копию для последующего сдвига и передачи в рекурсию
            copyNext.addAll(nextSet);
            copyNext.remove(i);
            rotate(copyNext);

        }

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
