package algo.book.chp1;

public final class CountUpAndDown {

    public static void main(String[] args) {
        countDownAndUp(5);
    }

    public static void countDownAndUp(int number) {
        System.out.println(number);
        if (number == 0) {
            System.out.println("Base case reached");
            return;
        }
        countDownAndUp(number - 1);
        System.out.println(number);
    }
}
