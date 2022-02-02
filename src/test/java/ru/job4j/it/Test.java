package ru.job4j.it;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] in = {
                {1}, {2, 3}
        };
        for (int[] s: in) {
            for (int t: s) {
                System.out.println(t);
            }
        }
    }
}
