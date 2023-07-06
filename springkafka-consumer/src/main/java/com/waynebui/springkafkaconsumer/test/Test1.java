package com.waynebui.springkafkaconsumer.test;

public interface Test1 {

    default void test(){
        System.out.println("Hello");
    }
}
