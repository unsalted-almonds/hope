package com.shilin.java8;

import java.util.function.Function;

// default strategy
public class MyStrategy<T> implements Function<T, String> {

    public static final String DEFAULT_LOG_MESSAGE = "Default logging: ETL failed. To specify logging strategy please set logging strategy when constructing stages";

    @Override
    public String apply(T t) {
        return DEFAULT_LOG_MESSAGE;
    }
}
