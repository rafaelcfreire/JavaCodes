package book.chp2;

import javax.inject.Inject;
 class Foo {
    private final Zoo zoo;

    @Inject
    Foo(Zoo zoo) {
        this.zoo = zoo;
    }
}