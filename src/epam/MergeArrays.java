package epam;

public class MergeArrays {
    public static void main(String[] args) {
        mergeArrays(new int[]{1,3,5,7,9}, new int[]{2,4,6,8});
    }

    public static int[] mergeArrays(int[] a, int[] b) {
        int[] mergedArray = new int[a.length + b.length];
        int aIndex = 0, bIndex = 0;

        for (int i = 0; i < mergedArray.length; i++) {
            if (a.length <= aIndex)
                mergedArray[i] = b[bIndex++];
            else if (b.length <= bIndex)
                mergedArray[i] = a[aIndex++];
            else if (a[aIndex] < b[bIndex])
                mergedArray[i] = a[aIndex++];
            else
                mergedArray[i] = b[bIndex++];
        }
        return mergedArray;
    }
}
