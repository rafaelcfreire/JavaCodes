package item42;

import java.util.function.DoubleBinaryOperator;

enum Operation {
//    PLUS("+") {
//        @Override
//        public double apply(double x, double y) {
//            return x + y;
//        }
//    },
//    MINUS("-") {
//        @Override
//        public double apply(double x, double y) {
//            return x - y;
//        }
//    },
//    TIMES("*") {
//        @Override
//        public double apply(double x, double y) {
//            return x * y;
//        }
//    },
//    DIVIDE("/") {
//        @Override
//        public double apply(double x, double y) {
//            return x / y;
//        }
//    };
    PLUS ("+", (x, y) -> x + y),
    MINUS ("-", (x, y) -> x - y),
    TIMES ("*", (x, y) -> x * y),
    DIVIDE ("/", (x, y) -> x / y);
    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }
//
//    public abstract double apply(double x, double y);
}
