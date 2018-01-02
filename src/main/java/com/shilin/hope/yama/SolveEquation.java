package com.shilin.hope.yama;

import java.util.Arrays;

/**
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+',
 * '-' operation, the variable x and its coefficient.
 * <p>
 * If there is no solution for the equation, return "No solution".
 * <p>
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * <p>
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 * <p>
 * Example 1: Input: "x+5-3+x=6+x-2" Output: "x=2" Example 2: Input: "x=x" Output: "Infinite solutions" Example 3:
 * Input: "2x=x" Output: "x=0" Example 4: Input: "2x+3x-6x=x+2" Output: "x=-1" Example 5: Input: "x=x+2" Output: "No
 * solution"
 */
public class SolveEquation {

    public static void main(String[] args) {
        SolveEquation test = new SolveEquation();

//        String res = test.solveEquation("3x=33+22+11");
//        System.out.println(res);

        int[] res = test.processOneSide("33+22+11");
        System.out.println(Arrays.toString(res));
    }

    public String solveEquation(String equation) {

        if (equation == null || equation.length() == 0) {
            return "No solution";
        }

        String[] leftAndRight = equation.split("=");
        int[] left = processOneSide(leftAndRight[0]);
        int[] right = processOneSide(leftAndRight[1]);

        int x = left[0] - right[0];
        int n = right[1] - left[1];

        if (x == 0 && n == 0) {
            return "Infinite solutions";
        }

        if (x == 0 && n != 0) {
            return "No solution";
        }

        return "x=" + (n / x);

    }

    private int[] processOneSide(String oneSide) {
        // [0] - x coefficient, [1] - number
        int[] res = new int[2];

        int sign = 1;
        // set coefficient as -1 to denote that it has not been calculated
        // coefficient will otherwise always greater than 0
        int coefficient = -1;
        for (int i = 0; i < oneSide.length(); i++) {
            char c = oneSide.charAt(i);

            switch (c) {
                case '+':
                    if (coefficient == -1) {
                        sign = 1;
                        break;
                    }
                    res[1] += coefficient * sign;
                    sign = 1;
                    coefficient = -1;
                    break;

                case '-':
                    if (coefficient == -1) {
                        sign = -1;
                        break;
                    }
                    res[1] += coefficient * sign;
                    sign = -1;
                    coefficient = -1;
                    break;
                case 'x':
                    if (coefficient == -1) {
                        res[0] += sign;
                    } else {
                        res[0] += coefficient * sign;
                        coefficient = -1;
                    }
                    break;
                // c is number
                default:
                    if (coefficient == -1) coefficient = 0;
                    coefficient = coefficient * 10 + c - '0';
                    if (i == oneSide.length() - 1) {
                        res[1] += coefficient * sign;
                    }

            }

        }

        return res;
    }

}
