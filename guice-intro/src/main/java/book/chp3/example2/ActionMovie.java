package book.chp3.example2;

import javax.inject.Inject;
import javax.inject.Named;

final class ActionMovie {
    @Inject @Named("stallone")
    private Actor actor;

    Actor getActor() {
        return this.actor;
    }
}