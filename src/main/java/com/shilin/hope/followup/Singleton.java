package com.shilin.hope.followup;

/**
 * Created by Shilin_Gan on 11/13/2017.
 */
public class Singleton {

    public static Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

}
