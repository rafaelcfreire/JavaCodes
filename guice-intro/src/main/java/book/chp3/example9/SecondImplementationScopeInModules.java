package book.chp3.example9;

import book.chp3.example6.Person;
import com.google.inject.Guice;
import com.google.inject.Injector;

final class SecondImplementationScopeInModules {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BindingModule());
        injector.getInstance(Person.class);
        injector.getInstance(Person.class);
    }
}