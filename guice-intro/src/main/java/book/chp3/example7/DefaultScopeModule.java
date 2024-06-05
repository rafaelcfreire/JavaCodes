package book.chp3.example7;

import book.chp3.example6.CustomScopes;
import com.google.inject.AbstractModule;

public class DefaultScopeModule extends AbstractModule {
    @Override
    protected void configure() {
        bindScope(DefaultScope.class, CustomScopes.DEFAULT);
    }
}