package com.shilin.hope.followup;

import java.util.ArrayList;
import java.util.List;

public class NthSqaure {

    public int solution(int n) {
        int result = 0;

        if (n < 1) {
            return result;
        }

        List<Integer> numbers = new ArrayList<Integer>(n);

        // start from 2, if we don't consider 1 is a square number
        int lastIdx = 0;
        numbers.add(4);
        int num = 3;
        while (lastIdx < n-1) {
            numbers.add(num*num);
            num++;
            lastIdx++;;
        }

        return numbers.get(numbers.size()-1);
    }

    public static void main(String args[]) {
        int result = new NthSqaure().solution(5);

        System.out.println(result);

    }

}
