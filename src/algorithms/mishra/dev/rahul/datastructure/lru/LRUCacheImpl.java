package algorithms.mishra.dev.rahul.datastructure.lru;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * I have used sentinel HEAD and TAIL nodes to mark the list boundary. Also with these sentinel nodes, I no longer have to perform
 * NULL check.
 *
 * Cache can perform two operations namely <b><code>PUT</code></b> and <b><code>GET</code></b>.
 *<p>
 * Created by aleesha on 16/07/17.
 * </p>
 */
public class LRUCacheImpl {
    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>();
        lruCache.put(1, 100);
        lruCache.put(2, 200);
        lruCache.put(3, 300);
        System.out.println(lruCache);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache);
        lruCache.put(4, 400);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache);
        lruCache.put(5, 500);
        System.out.println(lruCache);
        lruCache.put(5, 600);
        System.out.println(lruCache);
    }
}

/**
 * I have used sentinel HEAD and TAIL nodes to mark the list boundary. Also with these sentinel nodes, I no longer have to perform
 * NULL check. Also, in this implementation least recently used key-value entry is moved next to the HEAD and most frequently accessed
 * key-value pair is saved towards the end of the tail of linked list.
 *
 * Cache can perform two operations, namely <b><code>PUT</code></b> and <b><code>GET</code></b>.
 * <p>
 * <b>PUT</b> performs the following steps:
 * <li>
 *     Check if key is null - if yes, then return false
 * </li>
 * <li>
 *     Check if the key value already exists - if yes, then update the new value and return true
 * </li>
 * <li>
 *     Check if LRU has reached it' maximum capacity - if yes, then remove the least recently used entry from the cache and the linked list
 * </li>
 * <li>
 *     And then finally, create a new node with the given key-value pair. Add them to cache and linked list and return true
 * </li>
 * </p>
 * <p>
 *     <b>GET</b> performs the following steps:
 *     <li>
 *         Check if key is null - if yes, then return null
 *     </li>
 *     <li>
 *         Else, retrieve the value from the cache and move the key-value entry to the tail.
 *     </li>
 * </p>
 */
class LRUCache<K, V> {
    private static final int DEFAULT_CAPACITY = 3;
    private Map<K, Node> cache;
    private int size = 0;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache() {
        this(DEFAULT_CAPACITY);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        init();
    }

    // Initialize the sentinel nodes and connect them with each other
    private void init() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public boolean put(K key, V value) {
        if(Objects.isNull(key)) {
            System.out.println("Key is NULL. Cannot add NULL key to LRU Cache!!!");
            return false;
        }
        // If key already exists, then overwrite the new node value, else create a new entry
        if (!Objects.isNull(cache.get(key))) {
            updateKey(key, value);
            System.out.println("PUT: Updated cache with key: " + key + " and value: " + value);
            return true;
        }

        if (size == capacity) {
            removeLeastRecentlyUsedKeyFromCacheHead();
            size--;
        }

        addToCache(key, value);
        size++;
        System.out.println("PUT: Added to cache - key: " + key + " and value: " + value);
        return true;
    }

    public V get(K key) {
        Node nodeValue = cache.get(key);
        if(Objects.isNull(nodeValue)) {
            return null;
        }
        moveNodeToTail(nodeValue);
        System.out.println("GET: Retrieved from cache with key: " + key + " and value: " + nodeValue.value);
        return nodeValue.value;
    }

    private void moveNodeToTail(Node nodeValue) {
        // Break the links of the node and move it to the tail
        removeNodeLinks(nodeValue);
        addNodeLinks(nodeValue);
    }

    private void addNodeLinks(Node nodeValue) {
        Node prev = tail.prev;
        prev.next = nodeValue;
        nodeValue.prev = prev;
        nodeValue.next = tail;
        tail.prev = nodeValue;
    }

    private void removeNodeLinks(Node nodeValue) {
        Node prev = nodeValue.prev;
        Node next = nodeValue.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addToCache(K key, V value) {
        Node newNode = new Node(key, value);
        // When adding the 1st entry, head will be pointing to TAIL.
        newNode.next = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next.prev = newNode;
        cache.put(key, newNode);
    }

    private void removeLeastRecentlyUsedKeyFromCacheHead() {
        System.out.println("Cache limit exceeded. Evicting Least Recently Used entry: " + head.next);
        cache.remove(head.next.key);
        // Move head to the next node since the next node was evicted. Reset the value to NULL to indicate the sentinel HEAD node.
        head = head.next;
        head.key = null;
        head.value = null;
    }

    private void updateKey(K key, V value) {
        Node node = cache.get(key);
        node.value = value;
        cache.put(key, node);
    }

    @Override
    public String toString() {
        String string = "";
        Node curr = head.next;
        while(curr != tail) {
            string = string + curr.toString() + " ";
            curr = curr.next;
        }
        return string;
    }

    class Node {
        Node prev;
        Node next;
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "[K:" + key + " V:" + value + "]";
        }
    }
}