package algoexpert.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ContinuousMedian {
    public static void main(String[] args) {
        ContinuousMedianHandler pq = new ContinuousMedianHandler();
        pq.insert(5);
        pq.insert(10);
        pq.insert(100);
        pq.insert(200);
        pq.insert(6);
        pq.insert(13);
        pq.insert(14);
        pq.getMedian();
        pq.insert(50);
        pq.getMedian();
    }

    static class ContinuousMedianHandler {
        Heap lowers = new Heap(Heap::MAX_HEAP_FUNC, new ArrayList<Integer>());
        Heap greaters = new Heap(Heap::MIN_HEAP_FUNC, new ArrayList<Integer>());
        double median = 0;

        public void insert(int number) {
            if (lowers.length == 0 || number < lowers.peek())
                lowers.insert(number);
            else
                greaters.insert(number);
            rebalanceHeaps();
            updateMedian();
        }

        private void rebalanceHeaps() {
            if (lowers.length - greaters.length == 2) {
                greaters.insert(lowers.remove());
            } else if (greaters.length - lowers.length == 2) {
                lowers.insert(greaters.remove());
            }
        }

        private void updateMedian() {
            if (lowers.length == greaters.length) {
                median = ((double) lowers.peek() + (double) greaters.peek()) / 2;
            } else if (lowers.length > greaters.length) {
                median = lowers.peek();
            } else
                median = greaters.peek();
        }

        public double getMedian() {
            return median;
        }

    }

    static class Heap {
        private List<Integer> heap;
        private BiFunction<Integer, Integer, Boolean> function;
        private int length;

        public Heap(BiFunction<Integer, Integer, Boolean> comparisonFunction, List<Integer> array) {
            function = comparisonFunction;
            heap = buildHeap(array);
            length = array.size();
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIndex = (array.size() - 2) / 2;
            for (int currentIdx = firstParentIndex; currentIdx >= 0; currentIdx--) {
                siftDown(heap, currentIdx, heap.size() - 1);
            }
            return array;
        }

        private void siftDown(List<Integer> heap, int currentIdx, int endIdx) {
            int childOne = currentIdx * 2 + 1;

            while (childOne <= endIdx) {
                int childTwo = currentIdx * 2 + 2 > endIdx ? -1 : currentIdx * 2 + 2;
                int indexToSwap;

                if (childTwo != -1 && function.apply(heap.get(childTwo), heap.get(childOne))) {
                    indexToSwap = childTwo;
                } else {
                    indexToSwap = childOne;
                }

                if (function.apply(heap.get(indexToSwap), heap.get(currentIdx))) {
                    exchange(heap, currentIdx, indexToSwap);
                    currentIdx = indexToSwap;
                    childOne = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        private void siftUp(List<Integer> heap, int currentIdx) {
            int parentIdx = (currentIdx - 1) / 2;

            while (currentIdx > 0) {
                if (function.apply(heap.get(currentIdx), heap.get(parentIdx))) {
                    exchange(heap, currentIdx, parentIdx);
                    currentIdx = parentIdx;
                    parentIdx = (currentIdx - 1) / 2;
                } else {
                    return;
                }
            }
        }

        public void insert(int number) {
            heap.add(number);
            length++;
            siftUp(heap, heap.size() - 1);
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            exchange(heap, 0, heap.size() - 1);
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            length--;
            siftDown(heap, 0, heap.size() - 1);

            return valueToRemove;
        }

        public static boolean MAX_HEAP_FUNC(Integer a, Integer b) {
            return a > b;
        }

        public static boolean MIN_HEAP_FUNC(Integer a, Integer b) {
            return a < b;
        }

        private static void exchange(List<Integer> heap, int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }
}
