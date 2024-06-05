package book.chp3.example2;

import javax.inject.Inject;

final class Actor {

    private final String name;

    public Actor() {
        this.name = "Nicholas Cage";
    }

    @Inject
    public Actor(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}