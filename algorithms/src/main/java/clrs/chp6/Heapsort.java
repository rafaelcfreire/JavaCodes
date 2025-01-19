package clrs.chp6;

final class Heapsort {
    public static void main(String[] args) {
        Heapsort instance = new Heapsort();
        instance.heapsort(new int[]{5, 13, 2, 25, 7, 17, 20, 8, 4});
    }

    public void heapsort(int[] array) {
        buildMaxHeap(array);
        int boundary = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--) {
            exchange(array, 0, i);
            maxHeapify(array, 0, --boundary);
        }
    }

    private void buildMaxHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            maxHeapify(array, i, array.length - 1);
        }
    }

    private void maxHeapify(int[] array, int index, int boundary) {
        int l = left(index), r = right(index);
        int largest;

        if (l <= boundary && array[l] > array[index]) {
            largest = l;
        } else {
            largest = index;
        }

        if (r <= boundary && array[r] > array[largest]) {
            largest = r;
        }

        if (largest != index) {
            exchange(array, index, largest);
            maxHeapify(array, largest, boundary);
        }
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    private void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}