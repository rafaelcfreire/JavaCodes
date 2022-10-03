package leetcode.sorting;

// https://leetcode.com/problems/maximum-gap/
public final class MaximumGap {

    public static void main(String[] args) {
        maximumGap(new int[]{3, 6, 9, 1});
    }

    public static int maximumGap(int[] nums) {
        int n = nums.length;

        int m = nums[0];
        for (int i = 1; i < nums.length; i++) {
            m = Math.max(m, nums[i]);
        }
        int[] count = new int[m + 2];

        for (int i = 0; i < n; i++)
            count[nums[i] + 1]++;

        int maxGap = 0, currGap = 0;

        for (int i = count.length - 1; i > 0; i--) {
            if (count[i - 1] == 0)
                currGap++;
            else {
                if (currGap > maxGap)
                    maxGap = currGap;
                currGap = 0;
            }
        }
        return maxGap + 1;
    }

}
