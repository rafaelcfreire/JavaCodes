package epam;

public final class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 4);
        cache.put(2, 5);
        cache.put(2, 5);
        System.out.println(cache.get(1)); // returns 4
        System.out.println(cache.get(5)); // returns -1
        cache.put(3, 6); // removes key 2
        System.out.println(cache.get(2)); // retruns -1
    }

    private static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node[] lruCache;
    private int limit;

    public LRUCache(int limit) {
        if(limit < 0)
            throw new IllegalArgumentException("Capacity cannot be < 0");
        this.limit = limit;
    }

    //O(logN)
    public Integer get(int key) {
        return get(lruCache, 0, lruCache.length, key);
    }

    public int get(Node[] a, int low, int high, int target) {
        int middle = low + (high - low) / 2;

        while (low < high) {
            if (target < a[middle].key)
                high = middle - 1;
            else if (target > a[middle].key)
                low = middle + 1;
            else return a[middle].value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (lruCache == null) {
            lruCache = new Node[1];
            lruCache[0] = new Node(key, value, null);
        } else {
            if (limit == lruCache.length) {
                removeLRUsed();
            }

            Node currentNode = null;
            if(lruCache != null)
                currentNode = lruCache[0];

            while (key < currentNode.key) {
                currentNode = currentNode.next;
            }
            Node temp = currentNode.next;
            currentNode.next = new Node(key, value, temp);
            this.limit++;
        }
    }


    public void removeLRUsed() {
        Node[] temp = new Node[lruCache.length - 1];
        for (int i = 1; i < lruCache.length; i++)
            temp[i - 1] = lruCache[i];
    }
}
