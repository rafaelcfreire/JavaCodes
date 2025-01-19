package mjic.chp9;

import java.sql.SQLOutput;

final class StrategyExample {

    final ValidationStrategy strategy;

    public StrategyExample(ValidationStrategy v) {
        this.strategy = v;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

    interface ValidationStrategy {
        boolean execute(String s);
    }

    public static class IsAllLowerCase implements ValidationStrategy {
        @Override
        public boolean execute(final String s) {
            return s.matches("[a-z]+");
        }
    }

    public static class IsNumeric implements ValidationStrategy {
        @Override
        public boolean execute(final String s) {
            return s.matches("\\d+");
        }
    }

    public static void main(String[] args) {
        //WITHOUT LAMBDA
        StrategyExample example = new StrategyExample(new IsNumeric());
        boolean b1 = example.validate("aaaa");
        System.out.println(b1);

        StrategyExample example2 = new StrategyExample(new IsAllLowerCase());
        boolean b2 = example2.validate("bbbb");
        System.out.println(b2);

        //WITH LAMBDA
        StrategyExample example3 = new StrategyExample(string -> string.matches("\\d+"));
        boolean b3 = example3.validate("aaaa");
        System.out.println(b3);

        StrategyExample example4 = new StrategyExample(string -> string.matches("[a-z]+"));
        boolean b4 = example4.validate("bbbb");
        System.out.println(b4);
    }
}