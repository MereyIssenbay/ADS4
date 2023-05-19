import java.util.LinkedList;
public class MyHashTable<K, V> {
    public LinkedList<HashNode<K, V>>[] chain;; // or Object[]
    public int M = 11; //default number of chains
    public int size;

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
    public V get(K key){
        int index = hash(key);
        if (chain[index] == null) {
            return null;
        }
        for (HashNode<K, V> node: chain[index]){
            if(node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }
    public V remove(K key){
        int index = hash(key);
        LinkedList<HashNode<K, V>> list = chain[index];
        for (HashNode<K, V> node : list) {
            if (node.getKey().equals(key)) {
                V value = node.getValue();
                list.remove(node);
                size--;
                return value;
            }
        }
        return null;

    }
    public boolean contains(V value){
        for (int i = 0; i < M; i++) {
            LinkedList<HashNode<K, V>> list = chain[i];
            for (HashNode<K, V> node : list) {
                if (node.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }
    public K getKey(V value){
        for (int i = 0; i < M; i++) {
            LinkedList<HashNode<K, V>> list = chain[i];
            for (HashNode<K, V> node : list) {
                if (node.getValue().equals(value)) {
                    return node.getKey();
                }
            }
        }
        return null;
    }
    public V replace(K key, V oldValue, V newValue){
        int index = hash(key);
        for (HashNode<K, V> node: chain[index]){
            if(node.getKey().equals(key)){
                return newValue;
            }
        }
        return newValue;
    }

    public int getSize() {
        return size;
    }
}