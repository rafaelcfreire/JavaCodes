package demo.example;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;

final class BillingModule extends AbstractModule {
    @Provides
    @DefaultCreditCard.CCName
    String getCCName() {
        return "Rafael";
    }

    @Provides
    @DefaultCreditCard.CCNumber
    long getCCNumber() {
        return 5150L;
    }

    @Override
    protected void configure() {
        bind(Billing.class).to(DefaultBilling.class);
        bind(CreditCard.class).to(DefaultCreditCard.class);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BillingModule());
        Billing billing = injector.getInstance(Billing.class);
        billing.processBilling();
//        CreditCard card = injector.getInstance(CreditCard.class);
//        card.processCreditCard();

    }
}
