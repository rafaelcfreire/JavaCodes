package leetcode.divide_and_conquer;

// https://leetcode.com/problems/maximum-subarray/description/
final class MaximumSubarray {
    public static void main(String[] args) {
        int[] testArray = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        //int[] testArray = new int[]{5,4,-1,7,8};

        int sum = new MaximumSubarray().maxSubArray(testArray);
        System.out.println(sum);
    }

    public int maxSubArray(int[] nums) {
        return findMaximumSubarray(nums, 0, nums.length - 1);
    }

    private int findMaximumSubarray(int[] nums, int low, int high) {
        if (high == low)
            return nums[low];
        int middle = (low + high) / 2;
        int leftSum = findMaximumSubarray(nums, low, middle);
        int rightSum = findMaximumSubarray(nums, middle + 1, high);
        int crossSum = maxCrossingSubarray(nums, low, middle, high);

        if (leftSum >= rightSum && leftSum >= crossSum)
            return leftSum;
        else if (rightSum >= leftSum && rightSum >= crossSum)
            return rightSum;
        else
            return crossSum;
    }

    private int maxCrossingSubarray(int[] nums, int low, int middle, int high) {
        int left, right;

        int initialValue = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = middle; i >= low; i--) {
            sum = sum + nums[i];
            if (sum > initialValue) {
                initialValue = sum;
            }
        }
        left = initialValue;

        initialValue = Integer.MIN_VALUE;
        sum = 0;
        for (int i = middle + 1; i <= high; i++) {
            sum = sum + nums[i];
            if (sum > initialValue) {
                initialValue = sum;
            }
        }
        right = initialValue;

        return left + right;
    }
}