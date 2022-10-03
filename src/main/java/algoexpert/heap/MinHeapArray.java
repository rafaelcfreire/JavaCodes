package algoexpert.heap;

public final class MinHeapArray {
    public static void main(String[] args) {
//        new MinHeap(new int[]{8, 12, 23, 17, 31, 30, 44, 102, 18, 9});
//        MinHeap minHeap = new MinHeap(new int[]{48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41});
//        minHeap.insert(76);
//        minHeap.peek();
//        minHeap.remove();
//        minHeap.peek();
//        minHeap.remove();
//        minHeap.peek();
//        minHeap.insert(87);
        MinHeap minHeap = new MinHeap(new int[]{8, 5, 2, 9, 5, 6, 3});
    }

    static class MinHeap {
        int[] heap;

        public MinHeap(int[] array) {
            heap = new int[0];
            heap = buildHeap(array);
        }

        public int[] buildHeap(int[] array) {
            int firstParentIndex = (array.length - 2) / 2;
            for(int currentIndex = firstParentIndex; currentIndex >= 0; currentIndex--) {
                siftDown(currentIndex, array.length - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, int[] heap) {
            int childOne = currentIdx * 2 + 1;

            while(childOne <= endIdx) {
                int childTwo = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
                int indexToSwap;

                if(childTwo != -1 && heap[childTwo] < heap[childOne]) {
                    indexToSwap = childTwo;
                } else {
                    indexToSwap = childOne;
                }
                if(heap[indexToSwap] < heap[currentIdx]){
                    exchange(heap, currentIdx, indexToSwap);
                    currentIdx = indexToSwap;
                    childOne = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, int[] heap) {
            int parentIndex = getParentIndex(currentIdx);
            while(parentIndex >= 0 && heap[currentIdx] < heap[parentIndex]) {
                exchange(heap, parentIndex, currentIdx);
                currentIdx = parentIndex;
                parentIndex = getParentIndex(currentIdx);
            }
        }

        public int peek() {
            return heap[0];
        }

        public int remove() {
            int[] temp = new int[heap.length + 1];

            exchange(heap, 0, heap.length - 1);
            int valueToRemove = heap[heap.length - 1];
            for(int k = 0; k < heap.length - 1; k++)
                temp[k] = heap[k];

            siftDown(0, temp.length - 1, temp);
            heap = temp;
            return valueToRemove;
        }

        public void insert(int value) {
            int[] temp = new int[heap.length + 1];
            for(int k = 0; k < heap.length; k++)
                temp[k] = heap[k];
            temp[temp.length - 1] = value;
            siftUp(temp.length - 1, temp);
            heap = temp;
        }

        private int getParentIndex(int index) {
            return index > 0 ? ((index) - 1) / 2 : -1;
        }

        private void exchange(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
