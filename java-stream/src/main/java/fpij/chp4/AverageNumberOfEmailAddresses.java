package fpij.chp4;

import java.util.List;
import java.util.stream.Collectors;

final class AverageNumberOfEmailAddresses {
    public static void main(String[] args) {
        System.out.println(
        Person.SAMPLE_DATA.stream()
                .mapToDouble((person) -> person.emailAddresses().size())
                .average()
                .orElse(0));

        System.out.println(        Person.SAMPLE_DATA.stream()
                .collect(Collectors.averagingDouble((person) -> person.emailAddresses().size())));
    }
}
