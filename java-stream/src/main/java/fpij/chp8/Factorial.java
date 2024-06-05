package fpij.chp8;

final class Factorial {

    public static void main(String[] args) {
        try {
            System.out.println(factorialRec(20_000));
        } catch (StackOverflowError ex) {
            System.out.println(ex);
        }
    }

    static int factorialRec(final int number) {
        if (number == 1) {
            return 1;
        }
        return number * factorialRec(number - 1);
    }

//    static TailCall<Integer> factorialTailRec(final int factorial, final int number) {
//        if (number == 1) {
//            return done(factorial);
//        }
//        return call(() -> factorialTailRec(factorial * number, number - 1));
//    }
}
