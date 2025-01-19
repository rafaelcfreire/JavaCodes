package sedgewick.chp3;

public final class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("teste"));
    }

    public static boolean isPalindrome(String value) {
        if (value.length() == 0 || value.length() == 1)
            return true;
        String head = value.substring(0, 1);
        String middle = value.substring(1, value.length() - 1);
        String last = value.substring(value.length() - 1);

        return head.equals(last) && isPalindrome(middle);
    }
}
