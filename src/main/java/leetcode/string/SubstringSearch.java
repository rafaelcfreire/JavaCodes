package leetcode.string;

public final class SubstringSearch {

    public static void main(String[] args) {
//        int result = strStr("hello", "ll");
        int result = strStr("aaaaa", "bba");
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        int R = 256;
        int n = haystack.length();
        int m = needle.length();
        int[] right = new int[R];

        for (int i = 0; i < R; i++)
            right[i] = -1;

        for (int i = 0; i < m; i++)
            right[needle.charAt(i)] = i;

        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--)
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    skip = j - right[haystack.charAt(i + j)];
                    if (skip < 1)
                        skip = 1;
                    break;
                }
            if (skip == 0)
                return i;
        }
        return -1;
    }
}
