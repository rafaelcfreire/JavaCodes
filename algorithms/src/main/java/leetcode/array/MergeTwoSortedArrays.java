package leetcode.array;

// https://leetcode.com/problems/merge-sorted-array/
public final class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7, 9, 0, 0, 0, 0};
        int[] nums2 = {2, 4, 6, 8};

        merge(nums1, 5, nums2, 4);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        int index1 = 0, index2 = 0;

        for (int i = 0; i < temp.length; i++) {
            if (index1 >= m) {
                temp[i] = nums2[index2++];
            } else if (index2 >= n) {
                temp[i] = nums1[index1++];
            } else if (nums1[index1] < nums2[index2]) {
                temp[i] = nums1[index1++];
            } else
                temp[i] = nums2[index2++];
        }
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = temp[i];
    }
}
