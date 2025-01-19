package clrs.chp7;

final class QuicksortExample {

    public static void main(String[] args) {
        QuicksortExample quicksortExample = new QuicksortExample();
        int[] array = new int[]{9,7,4,3,6,1};

        quicksortExample.quicksort(array, 0, array.length - 1);
        System.out.println(array);
    }

    void quicksort(int[] nums, int low, int high) {
        if (high <= low)
            return;
        int pivot = partition(nums, low, high);
        quicksort(nums, low, pivot - 1);
        quicksort(nums, pivot + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int lowerIndex = low - 1;
        for (int i = low; i <= high; i++) {
            if (nums[i] < pivot) {
                lowerIndex = lowerIndex + 1;
                exchange(nums, i, lowerIndex);
            }
        }
        exchange(nums, lowerIndex + 1, high);
        return lowerIndex + 1;
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}