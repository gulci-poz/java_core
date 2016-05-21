package com.gulci.core;

//import java.util.Properties;
//import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        // block, compound statement - a number of Java segments
        // blok definiuje scope zmiennych
        /*
            int n;
            //zagnieżdżony blok
            {
                int k;
                // w zagnieżdżonym bloku nie można użyć nazwy, którą mamy powyżej
                int n;
            }
         */

        //Properties props = System.getProperties();
        //props.list(System.out);

        int target = 200;

        if (target > 200) {
            System.out.println("target > 200");
        } else if (target > 100) {
            System.out.println("target > 100");
        } else {
            System.out.println("small target");
        }

        int balance = 0;
        int goal = 1_000_000;
        int payment = 12000;
        int interestRate = 5;
        int years = 0;

        while (balance < goal) {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }

        System.out.println(years + " years");

        /*
        Scanner in = new Scanner(System.in);
        String input;
        balance = 0;
        payment = 12000;
        interestRate = 5;
        years = 0;

        do {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
            System.out.println("Balance: " + balance);
            System.out.print("Enough? ");
            input = in.next();
        } while (input.equals("N"));
        */

        // s. 99 - 3.8.4 Determinate Loops
    }
}
