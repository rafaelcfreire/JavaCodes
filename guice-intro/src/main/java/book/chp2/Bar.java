package book.chp2;

import javax.inject.Inject;

final class Bar extends Foo {

    @Inject
    Bar(final Zoo zoo) {
        super(zoo);
    }
}