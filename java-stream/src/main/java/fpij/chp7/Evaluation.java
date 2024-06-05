package fpij.chp7;

final class Evaluation {
    public static boolean evaluate(final int value) {
        System.out.println("Evaluating..."+value);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return value > 100;
    }

    public static void eagerEvaluator(final boolean input1, final boolean input2) {
        System.out.println("eagerEvaluator called...");
        System.out.println("accept?: "+(input1 && input2));
    }

    public static void main(String[] args) {
//        eagerEvaluator(evaluate(1), evaluate(2));
        MyClass myClass = new MyClass();
        synchronized (myClass) {
            new Thread(() -> myClass.foo()).start();

            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        synchronized (myClass) {
            new Thread(() -> myClass.foo()).start();
        }
    }

    static class MyClass {
        synchronized void foo() {
            System.out.println("My foo");
        }
    }
}
