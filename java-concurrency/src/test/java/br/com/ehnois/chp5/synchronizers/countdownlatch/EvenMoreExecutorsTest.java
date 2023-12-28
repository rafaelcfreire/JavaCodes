package br.com.ehnois.chp5.synchronizers.countdownlatch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.util.concurrent.Executor;

import static br.com.ehnois.chp5.synchronizers.countdownlatch.EvenMoreExecutors.flushExecutor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
final class EvenMoreExecutorsTest {
    @Test
    void flushExecutorNotFlushed(@Mock Executor executor) {
        boolean result = flushExecutor(executor, Duration.ofMillis(100));

        verify(executor).execute(any());
        assertThat(result, is(false));
    }

    @Test
    void testFlushExecutorFlushed(@Mock Executor executor) {
        doAnswer(invocation -> {
            ((Runnable)invocation.getArgument(0)).run();
            return null;
        }).when(executor).execute(any());
        assertThat(flushExecutor(executor, Duration.ofMillis(100)), is(true));
    }
}
