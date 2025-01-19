package mjic.chp11;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    class Car {
        private Optional<Insurance> insurance;

        public Optional<Insurance> getInsurance() {
            return insurance;
        }

        static class Insurance {
            private String name;

            public String getName() {
                return name;
            }
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        Optional<Person> optPerson = Optional.of(person1);

        Person person = new Person();
        getCarInsuranceName(person);
    }

    public static Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons
                .stream()
                .map(Person::getCar)
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optInsurance -> optInsurance.map(Car.Insurance::getName))
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());
    }

    public static String getCarInsuranceNameWithFlatMap(Optional<Person> person) {
        return person
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Car.Insurance::getName)
                .orElse("unknown");
    }

    public static String getCarInsuranceName(Person person) {
        return person.getCar().orElseThrow().getInsurance().orElseThrow().getName();
    }

    public static Optional<Car.Insurance> nullSafeFindCheapestInsurance(Optional<Person> person) {
        return person
                .flatMap(p -> p.getCar().map(c -> findCheapestInsurance(p, c)));
//        if (person.isEmpty() && car.isPresent()) {
//            return Optional.of(findCheapestInsurance(person.get(), car.get()));
//        } else {
//            return Optional.empty();
//        }
    }

    private static Car.Insurance findCheapestInsurance(final Person p, final Car c) {
        return new Car.Insurance();
    }
}