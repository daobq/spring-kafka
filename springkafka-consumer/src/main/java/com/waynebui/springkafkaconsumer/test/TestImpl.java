package com.waynebui.springkafkaconsumer.test;

public class TestImpl implements Test1{

    @Override
    public void test() {
        System.out.println("ZZZ");
    }

    public static void main(String[] args) {
        TestImpl test = new TestImpl();
        test.test();
    }
}
