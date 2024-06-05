package demo.bind;

import com.google.inject.*;
import demo.bind.SecondServiceImpl.Red;

import java.util.Map;

final class BinderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ServiceImpl.class).in(Singleton.class);
        //bind(Service.class).to(ServiceImpl.class);
        bind(Service.class).toProvider(ServiceProvider.class);
        bind(Service.class).annotatedWith(SecondServiceImpl.Red.class).to(SecondServiceImpl.class);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(Stage.PRODUCTION, new BinderModule());
        final Map<Key<?>, Binding<?>> allBindings = injector.getAllBindings();

        allBindings.entrySet().forEach(System.out::println);

        ServiceConsumer consumer = injector.getInstance(ServiceConsumer.class);
        System.out.println(consumer);
    }
}