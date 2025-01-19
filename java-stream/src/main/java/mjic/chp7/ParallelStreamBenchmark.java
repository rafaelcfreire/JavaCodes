package mjic.chp7;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamBenchmark {
    private static final long N = 10_000_000L;

    public long iterativeSum() {
        long result = 0;
        for (long i = 1L; i < N; i++) {
            result += i;
        }
        return result;
    }

    public long sequentialSum() {
        return Stream.iterate(1L, i -> i + i).limit(N)
                .reduce(0L, Long::sum);
    }

    public long rangedSum() {
        return LongStream.rangeClosed(1L, N)
                .reduce(0L, Long::sum);
    }

    public long parallelRangedSum() {
        return LongStream.rangeClosed(1L, N)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long result = new ParallelStreamBenchmark().iterativeSum();
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("IterativeSum took: "+endTime+", result="+result);

        long startTime2 = System.currentTimeMillis();
        long result2 = new ParallelStreamBenchmark().sequentialSum();
        long endTime2 = System.currentTimeMillis() - startTime2;
        System.out.println("sequentialSum took: "+endTime2+", result="+result2);

        long startTime3 = System.currentTimeMillis();
        long result3 = new ParallelStreamBenchmark().rangedSum();
        long endTime3 = System.currentTimeMillis() - startTime3;
        System.out.println("RangedSum took: "+endTime3+", result="+result3);

        long startTime4 = System.currentTimeMillis();
        long result4 = new ParallelStreamBenchmark().parallelRangedSum();
        long endTime4 = System.currentTimeMillis() - startTime4;
        System.out.println("parallelRangedSum took: "+endTime4+", result="+result4);
    }
}