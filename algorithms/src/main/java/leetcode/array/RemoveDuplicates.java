package leetcode.array;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public final class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = new int[]{1, 2, 2, 2, 2, 2, 2, 2};
        int result = removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        int index = 1;

        for (int i = index; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                nums[index++] = nums[i];
        }
        return index;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 1)
            return 1;

        int shiftedElements = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int pointerOne = i, pointerTwo = i + 1;
            if (pointerOne == 0 || nums[pointerOne] > nums[pointerOne - 1]) {
                while (nums[pointerTwo] == nums[pointerOne]) {
                    moveToEnd(nums, pointerTwo);
                    shiftedElements++;
                    if (shiftedElements == nums.length - 1 || shiftedElements == (nums.length - 1) - pointerOne) break;
                }
            } else if (nums[pointerOne] < nums[pointerOne - 1]) break;
        }
        return nums.length - shiftedElements;
    }

    private static void moveToEnd(int[] array, int index) {
        for (int i = index; i < array.length - 1; i++){
            int temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }
}


//    int index = 1;
//        for (int i = 1; i < nums.length; i++) {
//        if (nums[i] != nums[i - 1]) {
//        nums[index++] = nums[i];
//        }
//        }
//        return index;
