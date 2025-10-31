public class HashTable {
    private final int capacity;      // Size of the array
    private final HashNode[] table;  // Array to store the hash nodes
    private int size;                // Current number of elements in the table
    private int removeCount;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new HashNode[capacity];
        this.size = 0;
        this.removeCount = 0;
    }
    private int hash(int value) {return value % capacity;}
    public boolean isEmpty() {return size == 0;}
    public boolean isFull() {return size == capacity;}
    public int size() {return size;}
    public void insert(int value) {
        if (isFull()) {
            System.out.println("Hash table is full");
            return;
        }
        int index = hash(value);
        while (table[index] != null) {
            index = (index + 1) % capacity;
        }
        table[index] = new HashNode(value);
        size++;}
    public boolean search(int value) {
        if (isEmpty()) {
            System.out.println("Hash table is empty");
            return false;
        }
        int index = hash(value);
        while (table[index] != null && table[index].occupiedBefore) {
            if (table[index].node != null && table[index].node.value == value) {
                System.out.println("Found at index: " + index);
                return true;
            }
            index = (index + 1) % capacity;}
        System.out.println("Value not found");
        return false;}
//    private void removeByFlag(int value) {
//        int index = hash(value);
//
//        while (table[index] != null && table[index].occupiedBefore) {
//            if (table[index].node != null && table[index].node.value == value) {
//                table[index].node = null;
//                size--;
//                System.out.println("Removed value: " + value + " at index: " + index);
//                return;
//            }
//            index = (index + 1) % capacity;
//        }
//        removeCount--;
//        System.out.println("Value not found");
//    }
//    private void removeByRehash(int value) {
//        int index = hash(value);
//        boolean found = false;
//        while (table[index] != null) {
//            if (table[index].node != null && table[index].node.value == value) {
//                table[index] = null;
//                size--;
//                found = true;
//                System.out.println("Removed value: " + value + " at index: " + index);
//                break;
//            }
//            index = (index + 1) % capacity;}
//        if (!found) {
//            removeCount = 10;
//            System.out.println("Value not found");
//            return;
//        }
//        int rehashValue;
//        //Rehash all nodes after the deleted one
//        index = (index + 1) % capacity;
//        while (table[index] != null) {
//            if (table[index].node != null) {
//                rehashValue = table[index].node.value;
//                table[index] = null;
//                insert(rehashValue);
//            }else {
//                table[index] = null;
//            }
//            index = (index + 1) % capacity;}
//        //Rehash whole table
//        for (int i = 0; i < capacity; i++) {
//            if (table[i] != null && table[i].node != null) {
//                rehashValue = table[i].node.value;
//                table[i] = null;
//                insert(rehashValue);
//            } else {
//                table[i] = null;
//            }}}
    public void remove(int value) {
        if (isEmpty()) {
            System.out.println("Hash table is empty");
            return;}
//        if (removeCount == 10) {
//            removeCount = 0;
//            removeByRehash(value);
//        } else {
//            removeCount++;
//            removeByFlag(value);}
}
    public void print() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("index :" + i);
            if (table[i] != null && table[i].node != null) {
                System.out.println(" value :" + table[i].node.value);
            } else {
                System.out.println(" value :Null");
            }}
        System.out.println();}}