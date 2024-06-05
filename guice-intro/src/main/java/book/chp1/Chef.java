package book.chp1;

import javax.inject.Inject;

final class Chef {
    @Inject
    private FortuneService fortuneService;


    public Chef(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String makeFortuneCookie() {
        return fortuneService.randomFortune();
    }
}