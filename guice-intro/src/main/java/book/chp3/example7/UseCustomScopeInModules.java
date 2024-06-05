package book.chp3.example7;

import book.chp3.example6.Person;
import com.google.inject.Guice;
import com.google.inject.Injector;

final class UseCustomScopeInModules {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(
                new DefaultScopeModule(),
                new BindingsModule()
        );
        injector.getInstance(Person.class);
        injector.getInstance(Person.class);
    }
}