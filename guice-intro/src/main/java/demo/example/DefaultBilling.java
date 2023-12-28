package demo.example;

import com.google.inject.Inject;

final class DefaultBilling implements Billing {
    private final DefaultCreditCard creditCard;

    @Inject
    public DefaultBilling(final DefaultCreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public void processBilling() {
        System.out.println(String.format("Processing the following credit card: %s", creditCard));
    }
}
