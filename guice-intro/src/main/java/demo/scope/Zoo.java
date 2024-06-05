package demo.scope;

import javax.inject.Inject;

final class Zoo {
    private final Foo foo;

    @Inject
    Zoo(Foo foo) {
        this.foo = foo;
    }

    Foo getFoo() {
        return this.foo;
    }
}