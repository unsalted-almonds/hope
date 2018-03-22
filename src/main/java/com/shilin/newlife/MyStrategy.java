package com.shilin.newlife;

@FunctionalInterface
public interface MyStrategy<T> {

    String dump(T t);

}
