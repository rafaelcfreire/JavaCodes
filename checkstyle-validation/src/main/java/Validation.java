final class Validation {
    private String test;

    Validation() {
        doSomething();
    }

    private void doSomething() {
        String local = test.toUpperCase();
        test = null;
    }
}
