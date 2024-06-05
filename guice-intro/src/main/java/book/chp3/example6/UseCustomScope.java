package book.chp3.example6;

import com.google.inject.Guice;
import com.google.inject.Injector;

final class UseCustomScope {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new CustomScopeModule());
        injector.getInstance(Person.class);
        injector.getInstance(Person.class);
    }
}