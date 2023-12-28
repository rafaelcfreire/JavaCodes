package br.com.ehnois.chp5.synchronizers.future;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ExtendWith(MockitoExtension.class)
class FutureTaskExampleTest {

    FutureTaskExample futureTaskExample = new FutureTaskExample();

    @Test
    public void getContentFailTimeout() {
        Assertions.assertThrows(TimeoutException.class, () -> futureTaskExample.getContent().get(3000, TimeUnit.MILLISECONDS));
    }

}