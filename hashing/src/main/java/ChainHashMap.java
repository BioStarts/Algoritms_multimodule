import java.util.Iterator;
import java.util.LinkedList;

public class ChainHashMap {

    public static final int INVALID_INDEX = -1;
    public static final Integer INVALID_COST = null;

    public boolean wasInit = false;

    private class Entry {

        private ItemChain key;
        private int value;

        public Entry(ItemChain key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private int size;
    private int maxSize;
    private LinkedList<Entry>[] data;

    public ChainHashMap(int maxSize) {
        this.data = new LinkedList[maxSize];
        this.maxSize = maxSize;
    }

    private int hashFunc(int key) {
        return key;
    }



    public boolean put(ItemChain item, Integer cost) {
        if (size == maxSize) {
            return false;
        }

        int index = hashFunc(item.hashCode());//здесь мы определяем индекс нашего Item через первый символ его Title
            initializeList(this.data);
            data[index].add(new Entry(item, cost));
            size++;

        return true;
    }


    public Integer get(ItemChain item) {

        int index = hashFunc(item.hashCode());
        Iterator<Entry> iterator = data[index].iterator();
        while (iterator.hasNext()){
            Entry thisElem = iterator.next();
            if (thisElem.key.getTitle() == item.getTitle()){
                return thisElem.value;
            }
        }
        return INVALID_COST;
    }

    private int indexOf(ItemChain item) {
        return hashFunc(item.hashCode());
    }


    public boolean remove(ItemChain item) {
        int index = hashFunc(item.hashCode());

        Iterator<Entry> iterator = data[index].iterator();
        while (iterator.hasNext()){

            if (iterator.next().key.getTitle() == item.getTitle()){
                iterator.remove();
                return true;
            }
        }
        return false;

    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public void display() {
        System.out.println("----------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(String.format("%d = [%s]", i, data[i]));
        }
        System.out.println("----------------");

    }

    protected int getStep(int key) {
        return 1;
    }

    public void initializeList (LinkedList<Entry>[] nullList){
        if (wasInit == false) {
            for (int i = 0; i < nullList.length; i++) {
                nullList[i] = new LinkedList<>();
            }
            wasInit = true;
        }
    }
}
