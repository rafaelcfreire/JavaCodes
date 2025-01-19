package sedgewick.chp1;

public final class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(6));
    }

    public static long factorial(long number) {
        if (number == 1)
            return number;
        return number * factorial(number - 1);
    }

    public static long factorialIterative(long number) {
        long product = 1;

        for (long current = 1; current <= number; current++) {
            product = product * current;
        }
        return product;
    }
}
