package leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static final int CACHE_LIMIT = 3000;
    private Map<Integer, DoublyLinkedListNode> cache = new HashMap<>();
    private DoublyLinkedList list = new DoublyLinkedList();
    private int currentSize = 0;
    private int capacity;

    public LRUCache(int capacity) {
        if (capacity > CACHE_LIMIT)
            throw new RuntimeException(String.format("Cache limit of %s exceeded", CACHE_LIMIT));
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        updateHeadList(cache.get(key));
        return cache.get(key).value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            replaceKey(key, value);
        } else {
            if (currentSize == capacity)
                evictLeastRecent();
            else
                currentSize++;
            cache.put(key, new DoublyLinkedListNode(key, value));
        }
        updateHeadList(cache.get(key));
    }

    private void evictLeastRecent() {
        int key = list.tail.key;
        list.removeTail();
        cache.remove(key);
    }

    private void replaceKey(int key, int value) {
        if (!cache.containsKey(key))
            return;
        cache.get(key).value = value;
    }

    private void updateHeadList(DoublyLinkedListNode newHead) {
        list.setHeadTo(newHead);
    }

    static class DoublyLinkedList {
        DoublyLinkedListNode head;
        DoublyLinkedListNode tail;

        public void setHeadTo(DoublyLinkedListNode newHead) {
            if (head == newHead)
                return;
            if (head == null) {
                head = newHead;
                tail = newHead;
            } else if (head == tail) {
                newHead.next = tail;
                tail.prev = newHead;
                head = newHead;
            } else {
                if (tail == newHead)
                    removeTail();
                newHead.removeBindings();
                newHead.next = head;
                head.prev = newHead;
                head = newHead;
            }
        }

        public void removeTail() {
            if (tail == null)
                return;
            if (head == tail) {
                tail = null;
                head = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    static class DoublyLinkedListNode {
        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;
        int key;
        int value;

        public DoublyLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public void removeBindings() {
            if (prev != null)
                prev.next = next;
            if (next != null)
                next.prev = prev;
            next = null;
            prev = null;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
