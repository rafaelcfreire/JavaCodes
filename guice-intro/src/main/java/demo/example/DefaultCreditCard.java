package demo.example;

import com.google.inject.Inject;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

final class DefaultCreditCard implements CreditCard {
    private final String name;
    private final long number;

    @Inject
    public DefaultCreditCard(@CCName String name, @CCNumber long number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public void processCreditCard() {
        System.out.println(String.format("Creating credit card %s, %s", name, number));
    }

    @Override
    public String toString() {
        return String.format("Credit Card: %s, %d", name, number);
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @interface CCName {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @interface CCNumber {}
}
