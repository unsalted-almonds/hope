package com.shilin.hope.yama;

import java.util.Arrays;

public class MyApp {

    public static void main(String args[]) {

        String input = "x+5-3+x=6+x-2" ;

        String[] token = input.split("\\+|-|=");

        System.out.println(Arrays.toString(token));

    }
}
