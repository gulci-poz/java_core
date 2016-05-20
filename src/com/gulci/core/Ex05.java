package com.gulci.core;

//import java.util.Scanner;

import java.io.Console;

public class Ex05 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);

        /*
        System.out.print("Full name: ");
        String fullName = in.nextLine();

        System.out.print("Sex: ");
        // wczytanie słowa, bez białych znaków
        String sex = in.next();

        System.out.print("Age: ");
        int age = in.nextInt();

        System.out.println(fullName + " " + sex + " " + age);

        // hasNext() - sprawdza czy na wejściu jest kolejne słowo, jest wersja z int i double
        */

        // od JDK6 mamy klasę Console
        // można jej użyć do wczytania hasła
        // zawsze odczytujemy całą linię
        // po zakończeniu pracy z tablicą znaków warto przypisać wypełniacz
        // System.console() zwraca obiekt typu java.io.Console
        Console cons = System.console();
        // w drugim argumencie można podać formatowanie
        String userName = cons.readLine("User name: ");
        char[] password = cons.readPassword("Password: ");
        System.out.println("User name: " + userName);
        // toString() nie zrobi poprawnej konwersji
        // Idea nie wspiera interaktywnej konsoli, System.console() zwraca null
        // linia komend wspiera interaktywną konsolę
        // trzeba ręcznie przekompilować ctrl + shift + f9 przed uruchomieniem klasy z cmd
        System.out.println("Password: " + new String(password));
    }
}
