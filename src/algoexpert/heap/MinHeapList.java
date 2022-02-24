package algoexpert.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapList {
    public static void main(String[] args) {
//        new MinHeap(List.of(8, 12, 23, 17, 31, 30, 44, 102, 18, 9));
//        List list = Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41);
        List list = Arrays.asList(8, 5, 2, 9, 5, 6, 3);
        MinHeap minHeap = new MinHeap(list);
        minHeap.insert(76);
        minHeap.peek();

    }

    static class MinHeap {
        List<Integer> heap = new ArrayList<>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIndex = (array.size() - 2) / 2;
            for(int currentIndex = firstParentIndex; currentIndex >= 0; currentIndex--) {
                siftDown(currentIndex, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOne = currentIdx * 2 + 1;

            while(childOne <= endIdx) {
                int childTwo = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
                int indexToSwap;

                if(childTwo != -1 && heap.get(childTwo) < heap.get(childOne)) {
                    indexToSwap = childTwo;
                } else {
                    indexToSwap = childOne;
                }
                if(heap.get(indexToSwap) < heap.get(currentIdx)){
                    exchange(heap, currentIdx, indexToSwap);
                    currentIdx = indexToSwap;
                    childOne = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIndex = getParentIndex(currentIdx);
            while(currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIndex)) {
                exchange(heap, parentIndex, currentIdx);
                currentIdx = parentIndex;
                parentIndex = getParentIndex(currentIdx);
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            exchange(heap, 0, heap.size() - 1);
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        private int getParentIndex(int index) {
            return index > 0 ? (index - 1) / 2 : -1;
        }

        private void exchange(List<Integer> array, int i, int j) {
            int temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }
    }
}