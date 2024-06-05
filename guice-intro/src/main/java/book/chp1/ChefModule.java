package book.chp1;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

final class ChefModule implements Module {
    @Override
    public void configure(final Binder binder) {
        binder.bind(FortuneService.class)
                .to(FortuneServiceImpl.class)
                .in(Scopes.SINGLETON);
    }
}