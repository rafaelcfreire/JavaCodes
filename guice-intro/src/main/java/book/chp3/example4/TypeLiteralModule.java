package book.chp3.example4;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import java.util.ArrayList;
import java.util.List;

final class TypeLiteralModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<List<String>>(){})
                .annotatedWith(Names.named("list"))
                .to(new TypeLiteral<ArrayList<String>>(){});
        bind(new TypeLiteral<List<Integer>>(){})
                .annotatedWith(Names.named("list"))
                .to(new TypeLiteral<ArrayList<Integer>>(){});
    }
}