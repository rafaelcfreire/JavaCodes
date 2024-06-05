package demo.bind;

import javax.inject.Inject;

import java.util.Map;

import static demo.bind.SecondServiceImpl.*;

final class ServiceConsumer<K, V> {

    private final Service service;

    private Map<K, V> map;

    @Inject
    ServiceConsumer(@Red Service service) {
        this.service = service;
        //this.map = map;
    }
}