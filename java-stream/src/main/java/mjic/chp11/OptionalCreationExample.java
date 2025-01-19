package mjic.chp11;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

final class OptionalCreationExample {
    public static void main(String[] args) {
        //Optional Empty
        Optional<Car> optionalCar = Optional.empty();

        //Optional from a non-null value
        Car car = new Car();
        Optional<Car> optionalNonNullCar = Optional.of(car);

        //Optional from nullable
        Optional<Car> optCar = Optional.ofNullable(car);

    }

    static class Car { }
}