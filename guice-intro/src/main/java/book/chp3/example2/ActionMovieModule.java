package book.chp3.example2;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

import javax.inject.Named;

final class ActionMovieModule extends AbstractModule {
    @Override
    protected void configure() {
        //bind(Actor.class).annotatedWith(Names.named("stallone")).to(Actor.class);
        //bind(Actor.class).annotatedWith(Names.named("stallone")).toInstance(new Actor("stallone"));
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ActionMovieModule());
        ActionMovie movie = injector.getInstance(ActionMovie.class);
        System.out.println(movie.getActor().getName());
    }
}