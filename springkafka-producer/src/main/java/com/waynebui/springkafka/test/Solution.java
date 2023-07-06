package com.waynebui.springkafka.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int b = a.stream().filter(i -> i % 2 == 0).toList().stream().mapToInt(i -> i).sum();
    }
}
