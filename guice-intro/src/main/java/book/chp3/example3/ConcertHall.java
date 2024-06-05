package book.chp3.example3;

import javax.inject.Inject;
import javax.inject.Named;

final class ConcertHall {
    @Inject @Named("capacity")
    private int capacity;

    @Inject @Named("stage")
    private Class<?> stageType;

    @Inject @Named("setting")
    private Setting setting;

    @Override
    public String toString() {
        return String.format("%s[capacity=%s, setting=%s, stage type=%s]", getClass().getName(), capacity, setting, stageType);
    }

    enum Setting {
        INDOOR, OUTDOOR
    }
}