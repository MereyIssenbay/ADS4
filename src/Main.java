import java.util.Random;
class MyTestingClass {
    private int id;
    private String name;
    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> hashTable = new MyHashTable<>();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(rand.nextInt(100), "Name" + i);
            hashTable.put(key, i);
        }
        for (int i = 0; i < hashTable.M; i++) {
            System.out.println("Bucket " + i + ": " + hashTable.chain[i].size());
        }
    }
}