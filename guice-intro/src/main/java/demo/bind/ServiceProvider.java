package demo.bind;

import javax.inject.Provider;

final class ServiceProvider implements Provider<Service> {
    @Override
    public Service get() {
        return new ServiceImpl();
    }
}