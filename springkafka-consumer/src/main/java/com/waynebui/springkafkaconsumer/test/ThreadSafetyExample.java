package com.waynebui.springkafkaconsumer.test;

public class ThreadSafetyExample {

    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count--;
            }
        });

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println("Count: " + count);
    }
}