package algoexpert.linkedlist;


import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.insertKeyValuePair("b", 2);
        cache.insertKeyValuePair("a", 1);
        cache.insertKeyValuePair("c", 3);
        cache.getMostRecentKey();
        cache.getValueFromKey("a");
        cache.getMostRecentKey();
        cache.insertKeyValuePair("d", 4);
        cache.getValueFromKey("b");
        cache.insertKeyValuePair("a", 5);
        cache.getValueFromKey("a");
    }

    static class LRUCache {
        int maxSize;
        private Map<String, DoublyLinkedNode> cache = new HashMap<>();
        private DoublyLinkedList list = new DoublyLinkedList();
        private int currentSize = 0;

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        public void insertKeyValuePair(String key, int value) {
            if (cache.containsKey(key)) {
                replaceKey(key, value);
            } else {
                if (currentSize == maxSize)
                    evictLeastRecent();
                else
                    currentSize++;
                cache.put(key, new DoublyLinkedNode(key, value));
            }
            updateMostRecent(cache.get(key));
        }

        public LRUResult getValueFromKey(String key) {
            if (!cache.containsKey(key))
                return new LRUResult(false, -1);
            updateMostRecent(cache.get(key));
            return new LRUResult(true, cache.get(key).value);
        }

        public String getMostRecentKey() {
            if (list.head == null)
                return "";
            return list.head.key;
        }

        private void updateMostRecent(DoublyLinkedNode newItem) {
            list.setHeadTo(newItem);
        }

        private void evictLeastRecent() {
            String item = list.tail.key;
            list.removeTail();
            cache.remove(item);
        }

        private void replaceKey(String key, int value) {
            if (!cache.containsKey(key))
                return;
            cache.get(key).value = value;
        }
    }

    static class DoublyLinkedList {
        DoublyLinkedNode head;
        DoublyLinkedNode tail;

        public void setHeadTo(DoublyLinkedNode newHead) {
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

    static class DoublyLinkedNode {
        String key;
        int value;
        DoublyLinkedNode prev;
        DoublyLinkedNode next;

        public DoublyLinkedNode(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public void removeBindings() {
            if (prev != null)
                prev.next = next;
            if (next != null)
                next.prev = prev;
            prev = null;
            next = null;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

}
