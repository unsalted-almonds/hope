package com.shilin.newlife;

import java.util.function.Function;

public class FunctionDemo {
    //API which accepts an implementation of
    //Function interface
    static void modifyTheValue(int valueToBeOperated,
                               Function<Integer, Integer> function){

        int newValue = function.apply(valueToBeOperated);
    /*
     * Do some operations using the new value.
     */
        System.out.println(newValue);
    }

    static void modifyTheValue(Function function){
        Object res = function.apply("a string");
        System.out.println(res);
    }

    // in our case, passing down strategy, can strategy just execute/apply and taking the object we've create by calling get
    static <T, R> void modifyTheValue1(T input, Function<T, R> function){
        Object res = function.apply(input);
        System.out.println(res);
    }

    public static void main(String[] args) {

        modifyTheValue(val->val + " yes!");

        int incr = 20;
        int myNumber = 10;
        modifyTheValue(myNumber, val-> val + incr);

        myNumber = 15;
        modifyTheValue(myNumber, val-> val * 10);
        modifyTheValue(myNumber, val-> val - 100);
        modifyTheValue(myNumber, val-> "somestring".length() + val - 100);
    }
}
