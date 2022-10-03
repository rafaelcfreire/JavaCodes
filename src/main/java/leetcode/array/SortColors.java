package leetcode.array;

// https://leetcode.com/problems/sort-colors/
public final class SortColors {
    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }

    public static void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i])
                    swap(i, j, nums);
            }
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
