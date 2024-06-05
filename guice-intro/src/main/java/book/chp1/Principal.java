package book.chp1;

import com.google.inject.Guice;
import com.google.inject.Injector;

final class Principal {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ChefModule());
        Chef chef = injector.getInstance(Chef.class);
        System.out.println(chef.makeFortuneCookie());

        FortuneService fortuneService = injector.getInstance(FortuneService.class);
        System.out.println(fortuneService.randomFortune());
    }
}