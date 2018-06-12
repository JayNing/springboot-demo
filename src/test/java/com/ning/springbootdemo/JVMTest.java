package com.ning.springbootdemo;

public class JVMTest {

    public static final int NUM = 15000;

    public static void main(String[] args){
        for (int i = 0; i < NUM; i++) {
            calcNum();
        }
    }

    private static long calcNum() {
        long sum = 0;
        for (int i = 0; i <= 100 ; i++){
            sum += doubleValue(i);
        }
        return sum;
    }

    private static int doubleValue(int i) {
        for (int j=0; j < 100000; j++){
        }
        return i*2;
    }

}