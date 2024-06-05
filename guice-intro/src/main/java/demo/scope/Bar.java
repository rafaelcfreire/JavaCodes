package demo.scope;

import javax.inject.Inject;

final class Bar {
    private final Foo foo;

    @Inject
    Bar(Foo foo) {
        this.foo = foo;
    }

    Foo getFoo() {
        return this.foo;
    }
}