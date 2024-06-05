package book.chp3.example6;

import com.google.inject.AbstractModule;

final class CustomScopeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Person.class).in(CustomScopes.DEFAULT);
    }
}