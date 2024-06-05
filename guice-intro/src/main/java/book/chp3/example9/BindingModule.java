package book.chp3.example9;

import book.chp3.example6.Person;
import book.chp3.example7.DefaultScope;
import book.chp3.example7.DefaultScopeModule;
import com.google.inject.AbstractModule;

final class BindingModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new DefaultScopeModule());
        bind(Person.class).in(DefaultScope.class);
    }
}