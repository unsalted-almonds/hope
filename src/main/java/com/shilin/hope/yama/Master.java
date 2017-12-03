package com.shilin.hope.yama;

public class Master {

    public static void main(String[] args) {
        final String leetcode = "1,2,3,5,8,15,1,20,21,,23,42,48,49,73,78,89,98,102,119,121,126,127,138\n" +
                "139,141,146,155,160,167,186,199,200,204,206,215,234,235,236,238,239,240\n" +
                "242,297,355,380,387,396,414,438,449,451,459,460,508,516,517,529,532,534-538\n" +
                "545,579";

        String[] tockens = leetcode.split(",");

        System.out.println(tockens.length);

    }
}
