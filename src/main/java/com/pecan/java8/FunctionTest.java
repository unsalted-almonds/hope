package com.pecan.java8;

import java.util.function.Function;

public class FunctionTest<T> {

    Function<T, String> strategy;

    public static void main(String[] args) {
        FunctionTest<SimplePojo> myTest = new FunctionTest<>();

        myTest.setStrategy(SimplePojo::concat);

        String res = myTest.useStrategy(new SimplePojo("Hello", "World"));

        System.out.println(res);
    }

    public void setStrategy(Function<T, String> strategy) {
        this.strategy = strategy;
    }

    public String useStrategy(T input) {
        return this.strategy.apply(input);
    }

    public static class SimplePojo {

        private String str1;
        private String str2;
        private Integer i1;
        private Integer i2;

        public SimplePojo(String str1, String str2) {
            this.str1 = str1;
            this.str2 = str2;
        }

        public Integer add() {
            return i1 + i2;
        }

        public String concat() {
            return str1 + " " + str2;
        }

        public String getStr1() {
            return str1;
        }

        public void setStr1(String str1) {
            this.str1 = str1;
        }

        public String getStr2() {
            return str2;
        }

        public void setStr2(String str2) {
            this.str2 = str2;
        }

        public Integer getI1() {
            return i1;
        }

        public void setI1(Integer i1) {
            this.i1 = i1;
        }

        public Integer getI2() {
            return i2;
        }

        public void setI2(Integer i2) {
            this.i2 = i2;
        }
    }

}
