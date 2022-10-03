package algoexpert.string;

public final class Palindrome {
    public static void main(String[] args) {
//        System.out.println(isPalindromeRecursive("012210"));
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int low = 0, high = str.length() - 1;

        while (low < high) {
            if (str.charAt(low++) != str.charAt(high--))
                return false;
        }
        return true;
    }


//    private static boolean isPalindrome(String str) {
//        int low = 0, high = str.length() - 1;
//
//        while(low < high) {
//            if(str.charAt(low++) != str.charAt(high--)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean isPalindromeRecursive(String str) {
//        return isPalindromeRecursive(str, 0);
//    }
//
//    private static boolean isPalindromeRecursive(String str, int i) {
//        int j = str.length() - 1 - i;
//        return i >= j ? true : str.charAt(i) == str.charAt(j) && isPalindromeRecursive(str, i + 1);
//    }
}
