package book.chp3.example1;

import com.google.inject.Provider;

import javax.inject.Inject;

final class GumballMachine {

    Provider<Gum> gumProvider;

    @Inject
    GumballMachine(Provider<Gum> gumProvider) {
        this.gumProvider = gumProvider;
    }

    public Gum dispense() {
        return gumProvider.get();
    }
}