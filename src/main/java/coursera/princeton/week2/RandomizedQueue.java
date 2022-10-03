package coursera.princeton.week2;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] resizingArray;
    private int head;
    private int tail;
    private int count;

    public RandomizedQueue() {
        resizingArray = (Item[]) new Object[1];
        head = 0;
        tail = 0;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (count == resizingArray.length || tail == resizingArray.length)
            resize(2 * resizingArray.length);
        resizingArray[tail++] = item;
        count++;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        int i = 0;
        for (int j = 0; i < count; j++) {
            if (resizingArray[j] != null) {
                copy[i] = resizingArray[j];
                i++;
            }
        }

        resizingArray = copy;
        head = 0;
        tail = count;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int randomPlace = 0;
        Item item = null;
        do {
            randomPlace = StdRandom.uniform(head, tail);
        } while ((item = resizingArray[randomPlace]) == null);
        resizingArray[randomPlace] = null;
        count--;
        if (count > 0) {
            // invariant: array is between 25% and 100% full.
            if (count == resizingArray.length / 4) {
                resize(resizingArray.length / 2);
            } else if (head == randomPlace) {
                // invariant: head is in the interval [0; tail)
                // && array[head] == null
                for (; resizingArray[head] == null; head++)
                    ;
            } else if (tail == randomPlace - 1) {
                for (; resizingArray[tail - 1] == null; --tail)
                    ;
            }
        } else if (count == 0) {
            head = 0;
            tail = 0;
        }
        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int randomPlace = 0;
        Item item = null;
        do {
            randomPlace = StdRandom.uniform(head, tail);
        } while ((item = resizingArray[randomPlace]) == null);
        return item;
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private final Item[] currentArray;
        private int curr;

        RandomizedQueueIterator() {
            currentArray = (Item[]) new Object[count];

            int i = 0;
            for (int j = 0; i < count; j++) {
                if (resizingArray[j] != null) {
                    currentArray[i] = resizingArray[j];
                    i++;
                }
            }

            StdRandom.shuffle(currentArray);
            curr = 0;
        }

        @Override
        public boolean hasNext() {
            return curr != currentArray.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return currentArray[curr++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> randqueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            String sign = StdIn.readString();
            switch (sign) {
                case "+":
                    String item = StdIn.readString();
                    randqueue.enqueue(item);
                    break;
                case "-s":
                    if (!randqueue.isEmpty())
                        StdOut.print(randqueue.sample() + " ");
                    break;
                case "-d":
                    if (!randqueue.isEmpty())
                        StdOut.print(randqueue.dequeue() + " ");
                    break;
                default:
                    break;
            }
        }
        StdOut.println("(" + randqueue.size() + " left on rand queue)");
        for (String str : randqueue) {
            StdOut.print(str + " ");
        }
    }
}
