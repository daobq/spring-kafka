package com.waynebui.springkafka.controller;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Solution2 {
    public static void main(String[] args) {
        Day today = Day.MONDAY;

        if (today == Day.SUNDAY || today == Day.SATURDAY) {
            System.out.println("It's the weekend!");
        } else {
            System.out.println("It's a weekday.");
        }
    }
}

