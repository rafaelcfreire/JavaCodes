import org.example.BaseDriverState;
import org.example.ImmutableBaseDriverState;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BaseDriverTest {
    @Test
    void testDifferentInstances() {
        BaseDriverState b1 = ImmutableBaseDriverState.builder().value(4).feedType("any").build();

        BaseDriverState temp1 = b1.toBaseDriverState();
        BaseDriverState temp2 = b1.toBaseDriverState();

        assertThat(temp1 == temp2, is(true));
    }
}
