package book.chp3.example7;

import book.chp3.example6.Person;
import com.google.inject.AbstractModule;

public class BindingsModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Person.class).in(DefaultScope.class);
    }
}