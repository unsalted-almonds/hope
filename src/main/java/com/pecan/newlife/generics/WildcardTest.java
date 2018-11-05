package com.pecan.newlife.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest {

    public static void main(String[] args) {
        List<? super Integer> intSuperList = new ArrayList<>();

        intSuperList.add(0);

        // compiler error if element is Integer
        Object element = intSuperList.get(0);

        Class<?> classLiteral = String.class;

        System.out.println(classLiteral);

        System.out.println("123".getClass());
    }

    private static class UnknownType implements UnknownInterface {

        @Override
        public void handle(List<?> request) {
            add(request);
        }

        /**
         * use this helper method to capture the type
         * @param request
         * @param <T>
         */
        private <T> void add(List<T> request) {
            request.add(request.get(0));
        }
    }

}
