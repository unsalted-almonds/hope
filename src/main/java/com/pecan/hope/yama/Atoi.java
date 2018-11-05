package com.pecan.hope.yama;

/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself
 * what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to
 * gather all the input requirements up front.
 * <p>
 * Update (2015-02-10): The signature of the C++ function had been updated. If you still see your function signature
 * accepts a const char * argument, please click the reload button  to reset your code definition.
 * <p>
 * spoilers alert... click to show requirements for atoi.
 * <p>
 * Requirements for atoi: The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign
 * followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no
 * effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
 * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of
 * representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class Atoi {

    public static void main(String[] args) {
        Atoi test = new Atoi();

        int res = test.myAtoi("-3924a");
        System.out.println(res);

    }

    public int myAtoi(String str) {
        // If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters,
        int res = 0;
        if (str == null) return res;

        str = str.trim();
        if (str.length() == 0 || (str.charAt(0) != '+' && str.charAt(0) != '-' && !isNumber(str.charAt(0)))) {
            return res;
        }

        boolean positive = true;

        if (!isNumber(str.charAt(0))) {
            if (str.length() < 2) {
                return 0;
            }

            positive = !isNegative(str.charAt(0));

            if (!isNumber(str.charAt(1))) {
                return res;
            }

            // remove sign
            str = str.substring(1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (!isNumber(str.charAt(i))) {
                // first char not valid, return 0
                if (i == 0) {
                    return 0;
                }
                str = str.substring(0, i);
                break;
            }
        }

        int MAX_RES = Integer.MAX_VALUE % 10;
        int MIN_RES = -(Integer.MIN_VALUE % 10);
        int CHECK = Integer.MAX_VALUE / 10;

        for (int i = 0; i < str.length(); i++) {
            if (res > CHECK) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            int current = str.charAt(i) - '0';
            if (res == CHECK) {
                if (positive && current > MAX_RES) {
                    return Integer.MAX_VALUE;
                }
                if (!positive && current > MIN_RES) {
                    return Integer.MIN_VALUE;
                }
            }

            res = res * 10 + current;
        }

        return positive ? res : -res;


    }

    private boolean isNumber(char c) {

        return c >= '0' && c <= '9';
    }

    private boolean isNegative(char c) {
        return c == '-';
    }
}
