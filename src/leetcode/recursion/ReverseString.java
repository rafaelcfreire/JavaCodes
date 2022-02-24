package leetcode.recursion;

public class ReverseString {
    public static void main(String[] args) {
        reverseString("abbba");
        reverseString2(new char[]{'H','a', 'n', 'n', 'a', 'h'});
    }

    private static void reverseString(String str) {
        helper(0, str);
    }

    private static void helper(int index, String str) {
        if(index < 0 || index > str.length() - 1)
            return;
        helper(index + 1, str);
        System.out.print(str.charAt(index));
    }

    public static void reverseString2(char[] s) {
        helper2(s, 0, s.length - 1);
    }

    public static void helper2(char[] s, int indexOne, int indexTwo) {
        if(indexOne >= indexTwo)
            return;
        helper2(s, indexOne + 1, indexTwo - 1);
        exchange(s, indexOne, indexTwo);
    }

    public static void exchange(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
