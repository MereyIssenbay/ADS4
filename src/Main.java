import java.util.Random;

class MyTestingClass{
    private int val;
    public MyTestingClass(int v) {
        this.val = v;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(val);
    }
}

public class Main {
    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable<MyTestingClass, String>();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int val = rand.nextInt(0, 9999999);
            hashTable.put(new MyTestingClass(val), "Student " + val);
        }
        for (int i = 0; i < hashTable.M; i++) {
            System.out.println("Bucket " + i + ": " + hashTable.chain[i].size());
        }

    }
}