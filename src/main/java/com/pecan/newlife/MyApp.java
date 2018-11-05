package com.pecan.newlife;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class MyApp {

    public static void main(String[] args) {
        MyStrategy strategy = (dto) -> "hello world";

        MyStrategy<DummyDto> strategy1 = (dto) -> dto.getSomething();

        DummyDto dto = new DummyDto();

        Function myFunc = dto::getSomething;


//        MyContext<DummyDto> context = new MyContext<>();
//
//        context.setMyStrategy((dto1) -> dto1.getSomething());

        //System.out.println(context.execute(new DummyDto()));
        //context.execute(new DummyDto());

        Set<?> wildcardSet = new HashSet<>();



    }
}
