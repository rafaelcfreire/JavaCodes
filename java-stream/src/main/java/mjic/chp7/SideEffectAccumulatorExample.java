package mjic.chp7;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

final class SideEffectAccumulatorExample {

    static final long N = 10_000_000L;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long result = sideEffectSum(N);
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("sideEffectSum took: "+endTime+", result="+result);

        startTime = System.currentTimeMillis();
        result = sideEffectParallelSum(N);
        endTime = System.currentTimeMillis() - startTime;
        System.out.println("sideEffectParallelSum took: "+endTime+", result="+result);
    }

    static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1L, n)
                .forEach(accumulator::add);
        return accumulator.total.get();
    }

    static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1L, n)
                .parallel()
                .forEach(accumulator::add);
        return accumulator.total.get();
    }

    static class Accumulator {
        public AtomicLong total = new AtomicLong(0L);
        public void add(long value) {
            total.accumulateAndGet(value, Long::sum);
        }
    }
}