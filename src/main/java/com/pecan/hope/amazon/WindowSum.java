package com.pecan.hope.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There is a list and a window. The window says the number of elements to be added in the list, for example:
 * [4, 2, 73, 11, -5] and window size 2 should return [6, 75, 84, 6]
 * Created by Shilin_Gan on 11/20/2017.
 */
public class WindowSum {

    public static void main(String args[]) {
        WindowSum test = new WindowSum();
        System.out.println(test.solution(Arrays.asList(4, 2, 73, 11, -5), 2));
    }

    public List<Integer> solution(List<Integer> input, int size) {

        List<Integer> res = new ArrayList<>();

        if (input == null || input.size() == 0 || size < 1) {
            return res;
        }

        // if size is greater than size of input ???
        // this depends on how it is required

        int sum = 0;
        // construct first window sum
        for (int i = 0; i < size; i++) {
            sum += input.get(i);
        }

        res.add(sum);
        // from second window to the end
        for (int i = 1; i < input.size() - size + 1; i++) {
            int prev = input.get(i - 1);
            int add = input.get(i + size - 1);

            sum -= prev;
            sum += add;

            res.add(sum);
        }

        return res;
    }
}
