package com.pecan.newlife;

@FunctionalInterface
public interface MyStrategy<T> {

    String dump(T t);

}
