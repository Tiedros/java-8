package com.learnJavaMyVersion.parallelstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamBoxedExample {
    public static int sumSequential( List<Integer> integerList){
        long startTime = System.currentTimeMillis();
        int sum= integerList.stream()
                .reduce(0,(x,y)->x+y);
        long duration = System.currentTimeMillis()-startTime;
        System.out.println("Duration in sequential : "+ duration);
        return  sum;
    }
    public static int sumParallel( List<Integer> integerList){
        long startTime = System.currentTimeMillis();
        int sum= integerList.parallelStream()
                .reduce(0,(x,y)->x+y);
        long duration = System.currentTimeMillis()-startTime;
        System.out.println("Duration in parallel : "+ duration);
        return  sum;
    }
    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(1,10000)
                .boxed()
                .collect(Collectors.toList());
        sumSequential(integerList);
        sumParallel(integerList);
    }
}
