package book.chp3.example1;

import com.google.inject.Guice;

import com.google.inject.Injector;

import javax.inject.Inject;

final class Gum {

    private final Color color;

    @Inject
    public Gum(Color color) {
        this.color = color;
    }
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GumModule());
        GumballMachine gumballMachine = injector.getInstance(GumballMachine.class);
        System.out.println(gumballMachine.dispense());
        System.out.println(gumballMachine.dispense());
    }
}