package com.pecan.newlife;

import java.util.function.Predicate;

public class MyTest {

    public static void main(String[] args) {

        Predicate<Integer> atLeast5 = x -> x > 5;

        System.out.println(atLeast5.test(6));

    }

}
