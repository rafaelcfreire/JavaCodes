package book.chp3.example5;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

final class StaticModule extends AbstractModule {
    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("s")).to("D'OH!");
        requestStaticInjection(StaticInjection.class);
    }
}