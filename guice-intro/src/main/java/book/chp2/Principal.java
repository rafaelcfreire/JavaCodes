package book.chp2;

import com.google.inject.Guice;
import com.google.inject.Injector;

final class Principal {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Bar barExample = injector.getInstance(Bar.class);
        System.out.println(barExample);
    }
}