package com.learnJavaMyVersion.parallelstreams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamsExample {
    public static long checkPerformanceResult(Supplier<Integer> supplier, int numberOfTimes){
        long startTime = System.currentTimeMillis();
        for (int i=0;i<numberOfTimes;i++){
                supplier.get();
        }
        long endtime = System.currentTimeMillis();
        return endtime - startTime;

    }
    public static int sumSequentialStream(){
        return IntStream.rangeClosed(1,100000)
                .sum();

    }
    public static int sumParallelStream(){
        return IntStream.rangeClosed(1,100000)
                .parallel()
                .sum();

    }
    public static void main(String[] args) {
        System.out.println("# of Processors available on this machins is : "+ Runtime.getRuntime().availableProcessors());
        System.out.println("Sum sequential Total time : " + checkPerformanceResult(ParallelStreamsExample::sumSequentialStream,20));
        System.out.println("Sum parallel:  Total time : " + checkPerformanceResult(ParallelStreamsExample::sumParallelStream,20));

    }
}
