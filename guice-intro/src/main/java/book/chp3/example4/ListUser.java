package book.chp3.example4;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

final class ListUser {
    @Inject @Named("list")
    private List<String> strings;
    @Inject @Named("list")
    private List<Integer> integers;

    @Override
    public String toString() {
        return String.format("%s[strings=%s, integers=%s]",
                getClass().getName(),
                System.identityHashCode(strings),
                System.identityHashCode(integers));
    }
}