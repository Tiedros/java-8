package com.learnJavaMyVersion.parallelstreams;

import java.util.stream.IntStream;

public class SumClient {
    public static void main(String[] args) {
        Sum sum = new Sum();
        IntStream.rangeClosed(1,1000)
                .parallel()
                .forEach(sum::perform);//500500
        System.out.println(sum.getTotal());
    }
}
