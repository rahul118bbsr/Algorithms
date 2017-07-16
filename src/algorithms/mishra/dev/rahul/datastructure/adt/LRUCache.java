package algorithms.mishra.dev.rahul.datastructure.adt;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aleesha on 12/07/17.
 */
public class LRUCache {
    private Map<Integer, DLinkNode> cache;
    private DLinkNode tail = null;
    private DLinkNode head = null;
    private int capacity;

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.set(1, 100);
        cache.set(2, 200);
        cache.set(3, 300);
        cache.set(4, 400);
        cache.get(3);
        cache.get(4);
        cache.set(5, 500);
    }

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLinkNode target = cache.get(key);
            int value = target.value;
            target.update();
            return value;
        } else return -1;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkNode target = cache.get(key);
            target.value = value;
            target.update();
        } else {
            if (capacity == 0) return;
            if (cache.size() == capacity) {
                cache.remove(head.key);
                head.removeFromHead();
            }
            DLinkNode newNode = new DLinkNode(key, value);
            newNode.append();
            cache.put(key, newNode);
        }
    }

    class DLinkNode {
        int key;
        int value;
        DLinkNode prev = null;
        DLinkNode next = null;

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        // remove head from list and update head reference.
        private void removeFromHead() {
            // if 'this' is the only node, set both head and tail to null.
            if (tail == this) {
                head = null;
                tail = null;
            } else {
                head = this.next;
                head.prev = null;
            }
        }

        private void update() {
            // no need to update if accessing the most revently used value.
            if (tail == this) return;
            else {
                // remove from current postion and update nodes (if any) on both sides.
                if (this != head) {
                    this.prev.next = this.next;
                } else {
                    head = this.next;
                }
                this.next.prev = this.prev;
                // append to tail.
                this.append();
            }
        }

        private void append() {
            // inserting the first node.
            if (tail == null) {
                head = this;
                tail = this;
                // appned as tail and update tail reference.
            } else {
                this.next = null;
                this.prev = tail;
                tail.next = this;
                tail = this;
            }
        }
    }
}
