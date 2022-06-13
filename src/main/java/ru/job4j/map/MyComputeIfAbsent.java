package ru.job4j.map;

import java.util.*;
import java.util.Map;

public class MyComputeIfAbsent {
    public static void main(String[] args) {
        Map<String, String> myMap = new HashMap<>();
        myMap.computeIfAbsent("awesome key", key -> key + ", " + "amazing value");
        System.out.println(myMap.get("awesome key"));
    }
}
