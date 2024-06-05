package demo.scope;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

final class ScopeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Foo.class).in(Singleton.class);

    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ScopeModule());

        Bar bar = injector.getInstance(Bar.class);
        Zoo zoo = injector.getInstance(Zoo.class);

        System.out.println(bar.getFoo().equals(zoo.getFoo()));
    }
}