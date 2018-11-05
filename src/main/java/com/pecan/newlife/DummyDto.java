package com.pecan.newlife;

public class DummyDto {

    private int i1 = 1;
    private int i2 = 2;
    private String s1 = "s1";
    private String s2 = "s2";

    public String getSomething() {
        return s1 + s2;
    }

    public String getSomething(Object o) {
        return s1;
    }
}
