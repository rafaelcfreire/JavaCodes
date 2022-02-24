package leetcode.recursion;

public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(26));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;

        if (n % 3 != 0 || n == 0)
            return false;

        return isPowerOfThree(n / 3);
    }
}
