package book.chp3.example3;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

final class ConcertModule extends AbstractModule {
    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("capacity")).to("322");
        bindConstant().annotatedWith(Names.named("stage")).to("book.chp3.example3.BigStage");
        bindConstant().annotatedWith(Names.named("setting")).to("INDOOR");
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ConcertModule());
        ConcertHall concertHall = injector.getInstance(ConcertHall.class);

        System.out.println(concertHall.toString());
    }
}