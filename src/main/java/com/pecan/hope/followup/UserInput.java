package com.pecan.hope.followup;

import java.util.Scanner;

public class UserInput {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String firstInput = in.next();
            String secondInput = in.next();

            System.out.println("first input is " + firstInput + ", second input is " + secondInput);
        }

    }
}