package com.pecan.newlife;

public class SuperStrategy implements MyStrategy<DummyDto> {

    @Override
    public String dump(DummyDto dummyDto) {
        return dummyDto.getSomething();
    }
}

