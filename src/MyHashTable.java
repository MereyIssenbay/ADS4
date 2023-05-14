import java.util.LinkedList;
public class MyHashTable<K, V> {
    private LinkedList<HashNode<K, V>>[] chain;; // or Object[]
    private int M = 11; //default number of chains
    private int size;

    public MyHashTable(){
        chain = new LinkedList[M];
        size = 0;
    }
    public MyHashTable(int M){
        this.M = M;
        chain = new LinkedList[M];
        size = 0;
    }
    private int hash(K key) {
        return key.hashCode() % M;
    }

    public void put(K key, V value){
        int index = hash(key);
        if (chain[index] == null){
            chain[index] = new LinkedList<HashNode<K, V>>();
        }
        for (HashNode<K, V> node: chain[index]){
            if(node.getKey().equals(key)){
                node.setValue(value);
                return;
            }
        }
        chain[index].add(new HashNode<K, V>(key, value));
        size++;
    }
    public V get(K key){}
    public V remove(K key){}
    public boolean contains(V value){}
    public K getKey(V value){}

}