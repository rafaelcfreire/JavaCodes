package fpij.chp3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

final class SortingExample {
    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35)
        );

        Comparator<Person> ascending = (person1, person2) -> person1.ageDifference(person2);
        final List<Person> ascendingSorted = people.stream()
                .sorted(ascending)
                .collect(toList());

        final List<Person> descendingSorted = people.stream()
                .sorted(ascending.reversed())
                .collect(toList());

        //FLUENT COMPARISONS
        final List<Person> fluentComparison = people.stream()
                .sorted(comparing(Person::getAge).thenComparing(Person::getAge))
                .collect(toList());
    }
}
