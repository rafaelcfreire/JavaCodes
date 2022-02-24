package leetcode.array;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicatesII {

    public static void main(String[] args) {
//        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
//        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums = new int[]{1,1,1,2,2,3};
        int result = removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        int index = 2;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index - 2])
                nums[index++] = nums[i];
        }
        return index;
    }
}



//          int i = 0;
//          for (int n : nums)
//              if (i < 2 || n > nums[i-2])
//                  nums[i++] = n;
//          return i;
