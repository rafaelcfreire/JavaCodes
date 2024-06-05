package book.chp7;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;

final class SharingSingletons {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Water.class).in(Scopes.SINGLETON);
                bind(Drinkable.class).to(Water.class);
                bind(Carbonated.class).to(Water.class);
            }
        });
        Drinkable drinkable = injector.getInstance(Drinkable.class);
        Carbonated carbonated = injector.getInstance(Carbonated.class);

        System.out.println(drinkable.equals(carbonated));
    }
}