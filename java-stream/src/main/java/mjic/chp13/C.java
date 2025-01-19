package mjic.chp13;

/*
 * Three resolution rules:
 * 1) Classes always win
 * 2) Otherwise, subinterfaces win
 * 3) Finally, if the choice still ambiguous, the class inheriting from multiple interfaces
 * has to explicitly select which default method implementation to use.
 */
final class C extends D implements B, A {
    public static void main(String[] args) {
        new C().hello();
    }
}