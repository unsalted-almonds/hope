package com.pecan.hope.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fruit {


    public static void main(String[] args) {

        Fruit test = new Fruit();

        List<List<String>> codeList = new ArrayList<>();
        codeList.add(Arrays.asList("apple", "apple"));
        codeList.add(Arrays.asList("banana", "anything", "banana"));
        List<String> cart = Arrays.asList("other", "apple", "apple", "other", "banana", "orange", "banana");

        int res = test.solution(codeList, cart);

        System.out.println(res);
    }


    public int solution(List<List<String>> codeList, List<String> cart) {

        if (codeList == null || codeList.size() == 0) {
            return 1;
        }

        int pFruit = 0;
        int pCode = 0;
        while (pFruit < cart.size()) {
            int tmpPFruit = pFruit;
            int res = 1;

            for (String fruitCode : codeList.get(pCode)) {
                String fruit = cart.get(tmpPFruit);
                if (fruitCode.equals(fruit) || fruitCode.equals("anything")) {
                    tmpPFruit++;
                } else {
                    res = 0;
                    break;
                }
            }
            // pCodeth list matched
            if (res == 1) {
                // last list matched
                if (pCode == codeList.size() - 1) {
                    return 1;
                }
                pCode++;
                pFruit = tmpPFruit;
            } else {
                pFruit++;
            }
        }

        return 0;

    }
}
