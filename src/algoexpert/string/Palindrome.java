package algoexpert.string;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindromeRecursive("012210"));
    }

    private static boolean isPalindrome(String str) {
        int low = 0, high = str.length() - 1;
        boolean isPalindrome = true;

        while(low < high) {
            if(str.charAt(low++) != str.charAt(high--)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    private static boolean isPalindromeRecursive(String str) {
        return isPalindromeRecursive(str, 0);
    }

    private static boolean isPalindromeRecursive(String str, int i) {
        int j = str.length() - 1 - i;
        return i >= j ? true : str.charAt(i) == str.charAt(j) && isPalindromeRecursive(str, i + 1);
//        if (i >= j)
//            return true;
//        else
//            return str.charAt(i) == str.charAt(j) && isPalindromeRecursive(str, i + 1);
    }
}
