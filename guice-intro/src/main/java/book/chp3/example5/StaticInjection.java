package book.chp3.example5;

import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.inject.Inject;
import javax.inject.Named;

final class StaticInjection {
    @Inject
    public static void staticMethod(@Named("s") String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new StaticModule());
        System.out.println(injector.getAllBindings());
    }
}