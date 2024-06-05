package book.chp3.example4;

import com.google.inject.Guice;
import com.google.inject.Injector;

// Type Literal example
final class TypeLiteralExample {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TypeLiteralModule());
        System.out.println(injector.getInstance(ListUser.class));
    }
}