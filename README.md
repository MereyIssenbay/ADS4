### 🔹 Function: hash
Description: 
This method accepts a key of the K data type and generates a hash value for the key. To compute the hash value, it invokes the hashCode() method on the key object and then applies the modulo operation with the hash table size M. The result of the modulo operation is used to determine the index where the key-value pair will be stored.

Code:
```java
private int hash(K key) {
        return key.hashCode() % M;
    }
```

### 🔹 Function: put
Description: This function is used to insert a key-value pair into the hash table. It calculates the index using the hash function, and if the chain at that index is null, it creates a new LinkedList to store multiple key-value pairs. It then iterates over the chain to check if the key already exists. If found, it updates the value; otherwise, it adds a new HashNode with the given key and value.

Code:
```java
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
```

### 🔹 Function: get
Description:
The purpose of this function is to find and return the value that is associated with a particular key in a hash table. To do this, it uses a hash function to calculate an index where the key might be stored in the table, and then searches through the chain of nodes at that index to see if there is a node that contains the given key. If a node with the key is found, the function returns the value associated with that key. If the key is not found in the hash table, the function returns null.


Code:
```java
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
```

### 🔹 Function: remove
Description:This function removes a key-value pair from the hash table by using a hash function to calculate the index of the key. It searches through the chain at that index to find the matching key and removes the corresponding HashNode. If successful, it returns the value associated with the key; otherwise, it returns null.

Code:
```java
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
```

### 🔹 Function: contains
Description: This function checks if a specified value exists in the hash table by searching through all the chains and comparing the values in each HashNode. It returns true if the value is found and false if it is not.

Code:
```java
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
```

### 🔹 Function: getKey
Description: This function searches for a specified value in all the hash table chains by comparing it with the values in each HashNode. It returns true if the value is found and false if not.


Code:
```java
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
```
