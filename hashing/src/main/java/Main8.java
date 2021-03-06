public class Main8 {

    public static void main(String[] args) {
        doubleHashTableTest();
        hashTableTest();

        chainHashMapTest();

    }

    private static void chainHashMapTest() {
        ChainHashMap hashTable = new ChainHashMap(1100);
        hashTable.put(new ItemChain(5,"Уу"),120);
        hashTable.put(new ItemChain(5,"Уеееес"),120);
        hashTable.remove(new ItemChain(5,"Уу"));

        System.out.println("Size is " + hashTable.getSize());

        hashTable.display();

        System.out.println(hashTable.get(new ItemChain(5,"Уеееес")));
    }

    private static void hashTableTest() {
        HashTable hashTable = new HashTableImpl(5);
        hashTable.put(new Item(1, "Mango"),150);
        hashTable.put(new Item(77,"Banana"),100);
        hashTable.put(new Item(62,"Lemon"),250);
        hashTable.put(new Item(21,"Potato"),67);
        hashTable.put(new Item(55,"Milk"),120);

        System.out.println("Size is " + hashTable.getSize());

        hashTable.display();

        System.out.println("Cost potato is " + hashTable.get(new Item(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Item(77,"Banana")));

        hashTable.remove(new Item(77,"Banana"));
        System.out.println("Cost banana is " + hashTable.get(new Item(77,"Banana")));
    }

    private static void doubleHashTableTest() {
        HashTable hashTable = new DoubleHashTableImpl(10);
        hashTable.put(new Item(1, "Mango"),150);
        hashTable.put(new Item(77,"Banana"),100);
        hashTable.put(new Item(62,"Lemon"),250);
        hashTable.put(new Item(21,"Potato"),67);
        hashTable.put(new Item(55,"Milk"),120);

        System.out.println("Size is " + hashTable.getSize());

        hashTable.display();

        System.out.println("Cost potato is " + hashTable.get(new Item(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Item(77,"Banana")));

        hashTable.remove(new Item(77,"Banana"));
        System.out.println("Cost banana is " + hashTable.get(new Item(77,"Banana")));
    }
}
