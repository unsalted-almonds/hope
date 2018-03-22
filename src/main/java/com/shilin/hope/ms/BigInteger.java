package com.shilin.hope.ms;

public class BigInteger {

    private String bigInteger;

    public BigInteger(String bigInteger) {
        this.bigInteger = bigInteger;
    }

    // time O(n) space O(1)
    public String add(String num) {
        String res = "";
        int m = bigInteger.length(), n = num.length(), i = m - 1, j = n - 1, flag = 0;
        while(i >= 0 || j >= 0){
            int a, b;
            if(i >= 0){
                a = bigInteger.charAt(i--) - '0';
            }
            else{
                a = 0;
            }
            if(j >= 0){
                b = num.charAt(j--) - '0';
            }
            else{
                b = 0;
            }
            int sum = a + b + flag;
            res =(char)(sum % 10 + '0') + res;
            flag = sum / 10;
        }
        return flag == 1 ? "1" + res: res;
    }

    // time O(len1 * len2) space O(len1 + len2)
    public String multiply(String num) {
        if (bigInteger == null || num == null) {
            return null;
        }

        int len1 = bigInteger.length(), len2 = num.length();
        int len3 = len1 + len2;
        int i, j, product, carry;

        int[] num3 = new int[len3];
        for (i = len1 - 1; i >= 0; i--) {
            carry = 0;
            for (j = len2 - 1; j >= 0; j--) {
                product = carry + num3[i + j + 1] +
                        Character.getNumericValue(bigInteger.charAt(i)) *
                                Character.getNumericValue(num.charAt(j));
                num3[i + j + 1] = product % 10;
                carry = product / 10;
            }
            num3[i + j + 1] = carry;
        }

        StringBuilder sb = new StringBuilder();
        i = 0;

        while (i < len3 - 1 && num3[i] == 0) {
            i++;
        }

        while (i < len3) {
            sb.append(num3[i++]);
        }

        return sb.toString();
    }

}
