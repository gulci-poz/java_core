package com.gulci.core;

import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        // jeśli pominiemy formatowanie, to wczytywane jest domyślne formatowanie komputera
        // musimy dodać do sygnatury metody throws IOException lub użyć bloku try/catch
        // wyrzucany jeśli Scanner dostanie nieistniejący plik
        // lub jeśli PrintWriter dostanie plik z nazwą, która nie może być utworzona
        // pierwszy argument to obiekt typu Path
        Scanner in = new Scanner(Paths.get("C:\\users\\gulci\\desktop\\test.txt"), "UTF-8");
        String content = in.nextLine();
        System.out.println(content);

        // Scanner można skonstruować z argumentem typu String, widzi wtedy dane, a nie nazwę pliku

        // ścieżka jest relatywna względem folderu, gdzie wystartowała wirtualna maszyna
        System.out.println(System.getProperty("user.dir"));

        // na obiekcie typu PrintWriter możemy używać metdo print, println, printf, append
        PrintWriter out = new PrintWriter("C:\\users\\gulci\\desktop\\test.txt", "UTF-8");
        // append kasuje wcześniejszą zawartość pliku
        out.append(content + " hello");
        out.close();
    }
}
