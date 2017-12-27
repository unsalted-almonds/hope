package com.shilin.hope.yama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApp {

    public static void main(String args[]) {

        List<Integer> strList = Arrays.asList(new Integer[]{22,13,3,4});

        System.out.println(strList);

        String data = strList.toString();
        data = data.substring(1, data.length() - 1);

        String[] preorderString = data.split("\\s*,\\s*");
        List<Integer> preorder = new ArrayList<>();

        for (String str : preorderString) {
            preorder.add(Integer.valueOf(str));
        }

        System.out.println(preorder);

        Arrays.asList(1,2,3);
    }
}
