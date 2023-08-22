package com.learnJavaMyVersion.parallelstreams;

public class Sum {
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void perform(int input){
        total+=input;
    }
}
