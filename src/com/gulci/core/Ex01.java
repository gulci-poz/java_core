package com.gulci.core;

/**
 * Java Core Sample Program
 * @version 0.1 2016-05-18
 * @author gulci
 */

public class Ex01 {

    public static void main(String[] args) {
        String greeting = "Welcome to Core!";
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++) {
            System.out.print("=");
        }
        System.out.println("");
    }
}
