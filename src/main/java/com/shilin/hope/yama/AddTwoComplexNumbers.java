package com.shilin.hope.yama;

/**
 * Given two strings representing two complex numbers.
 * <p>
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * <p>
 * Example 1: Input: "1+1i", "1+1i" Output: "0+2i" Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need
 * convert it to the form of 0+2i. Example 2: Input: "1+-1i", "1+-1i" Output: "0+-2i" Explanation: (1 - i) * (1 - i) = 1
 * + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i. Note:
 * <p>
 * The input strings will not have extra blank. The input strings will be given in the form of a+bi, where the integer a
 * and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */
public class AddTwoComplexNumbers {
    public String complexNumberMultiply(String a, String b) {

        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return "";
        }

        String[] aArr = a.split("\\+");
        String[] bArr = b.split("\\+");

        // "1+-1i", "1+-1i"
        // a "1", "-1i"
        // b "1", "-1i"
        int coefficientA = stringToInteger(aArr[1].split("i")[0]);
        int coefficientB = stringToInteger(bArr[1].split("i")[0]);
        int numberA = stringToInteger(aArr[0]);
        int numberB = stringToInteger(bArr[0]);

        int resICoefficient = coefficientA * numberB + coefficientB * numberA;
        int resNumber = numberA * numberB - (coefficientA * coefficientB);

        return "" + resNumber + "+" + resICoefficient + "i";
    }

    private int stringToInteger(String str) {
        char[] strArr = str.toCharArray();
        boolean negative = false;
        int res = 0;
        int digit = 1;
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (strArr[i] == '-') {
                negative = true;
                continue;
            }
            res += (strArr[i] - '0') * digit;
            digit *= 10;
        }
        if (negative) {
            res = 0 - res;
        }

        return res;
    }
}
