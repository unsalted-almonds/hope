package com.shilin.newlife;

import java.util.function.Function;

public class MyContext<T, R> {

    private MyStrategy<T> myStrategy;

    public void setMyStrategy(MyStrategy<T> myStrategy) {
        this.myStrategy = myStrategy;
    }

    public String execute(T t) {
        return myStrategy.dump(t);
    }

//    public MyContext<T> withStrategy(Class dtoType, MyStrategy<T> myStrategy) {
//        this.myStrategy = myStrategy;
//        return this;
//    }

    public MyContext<T, R> withStrategy(T dtoType, Function<T, R> function) {

        function.apply(dtoType);

        this.myStrategy = myStrategy;
        return this;
    }

}
