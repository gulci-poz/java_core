package com.gulci.core;

import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
//import java.io.PrintWriter;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        // jeśli pominiemy formatowanie, to wczytywane jest domyślne formatowanie komputera
        // musimy dodać do sygnatury metody throws IOException lub użyć bloku try/catch
        Scanner in = new Scanner(Paths.get("C:\\users\\gulci\\desktop\\test.txt"), "UTF-8");
        System.out.println(in.next());

        // Scanner można skonstruować z argumentem typu String, widzi wtedy dane, a nie nazwę pliku

        //PrintWriter out = new PrintWriter("C:\\users\\gulci\\desktop\\test.txt", "UTF-8");
        // na obiekcie typu PrintWriter możemy używać metdo print, println, printf
        //out.print("hello");

        // otwarcie obiektu typu PrintWriter domyślnie usuwa zawartość pliku
        // s. 88
    }
}
