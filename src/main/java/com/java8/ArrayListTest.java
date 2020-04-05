package com.java8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in";

//        List<Long> ol = new ArrayList<Long>(); // Incompatible types
//        ol.add("I don't fit in");
        Arrays.stream(objectArray).forEach(System.out::println);
    }
}
