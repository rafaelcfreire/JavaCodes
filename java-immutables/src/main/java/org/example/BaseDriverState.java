package org.example;

import org.immutables.value.Value;
import org.example.ImmutableBaseDriverState;

@Value.Immutable
@Value.Style(strictBuilder = true)
public interface BaseDriverState {
    String getFeedType();

    double getValue();

    @Value.Lazy
    default BaseDriverState toBaseDriverState() {
        return ImmutableBaseDriverState.builder().value(4).feedType("any").build();
    }
}
