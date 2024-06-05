package mjic.chp3;

import java.util.concurrent.Callable;

final class CallableExample {

    static Callable<String> getCallable() {
        return () -> "Trick Example";
    }
    public static void main(String[] args) throws Exception {
        System.out.println(CallableExample.getCallable().call());
    }
}