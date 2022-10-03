package leetcode.recursion;

public final class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(7));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1)
            return true;

        if (n % 2 != 0 || n == 0)
            return false;

        return isPowerOfTwo(n / 2);
    }
}
