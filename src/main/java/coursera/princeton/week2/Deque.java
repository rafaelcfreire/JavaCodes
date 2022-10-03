package coursera.princeton.week2;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Deque<Item> implements Iterable<Item> {

    private DoublyLinkedNode first;
    private DoublyLinkedNode last;
    private int count;

    private class DoublyLinkedNode {
        private DoublyLinkedNode previous;
        private DoublyLinkedNode next;
        private Item item;
    }

    public Deque() {}

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return count;
    }

    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        DoublyLinkedNode newFirst = new DoublyLinkedNode();
        newFirst.next = first;
        newFirst.previous = null;
        newFirst.item = item;

        first = newFirst;
        if (last == null)
            last = first;
        if (first.next != null)
            first.next.previous = first;
        count++;
    }

    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        DoublyLinkedNode newLast = new DoublyLinkedNode();
        if (last != null)
            newLast.previous = last;
        last = newLast;
        if (first == null)
            first = newLast;
        count++;
    }

    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        DoublyLinkedNode oldFirst = first;
        first = first.next;
        first.previous = null;
        count--;
        return oldFirst.item;
    }

    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (last == null)
            return null;
        DoublyLinkedNode oldLast = last;
        last = last.previous;
        if (first == null)
            first = last;
        count--;
        return oldLast.item;
    }

    public Iterator<Item> iterator() {
        return new DoubleLinkedListIterator(first);
    }

    private class DoubleLinkedListIterator implements Iterator<Item> {

        private DoublyLinkedNode current;

        public DoubleLinkedListIterator(DoublyLinkedNode first) {
            current = first;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item currItem = current.item;
            current = current.next;
            return currItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        while (!StdIn.isEmpty()) {
            String sign = StdIn.readString();
            switch (sign) {
                case "+f":
                    String itemOnFirst = StdIn.readString();
                    deque.addFirst(itemOnFirst);
                    break;
                case "+l":
                    String itemOnLast = StdIn.readString();
                    deque.addLast(itemOnLast);
                    break;
                case "-f":
                    if (!deque.isEmpty())
                        StdOut.print(deque.removeFirst() + " ");
                    break;
                case "-l":
                    if (!deque.isEmpty())
                        StdOut.print(deque.removeLast() + " ");
                    break;
                default:
                    break;
            }
        }
        StdOut.println("(" + deque.size() + " left on deque)");
        for (String str : deque) {
            StdOut.print(str + " ");
        }
    }
}
