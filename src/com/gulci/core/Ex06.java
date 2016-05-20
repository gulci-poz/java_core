package com.gulci.core;

import java.util.Date;

public class Ex06 {
    public static void main(String[] args) {
        double x = 10000.0 / 3.0;
        // ew. spacja z przodu, szerokość pola . precyzja
        System.out.printf("%,8.2f", x);
        System.out.println();
        // d, f, s, c, b - wiadomo
        // o, x - oktalny i heksalny int
        // e - float w postaci wykładniczej
        // g - general floating-point (zamiast e lub f)
        // a - heksalny float
        // h - hash code
        // tx lub Tx (forces uppercase) - data i czas; obsolete - teraz klasy z java.time
        // x - litera formatująca - tabela s. 85/86
        // to jest stare formatowanie - dla klasy Date
        // % - symbol procentu
        // n - separator linii zależny od platformy
        // s można używać do formatowania dowolnych obiektów
        // jeśli obiekt implementuje interfejs Formattable, wywoływana jest metoda formatTo()
        // w przeciwnym wypadku jest wywoływana metoda toString()
        // można też dodawać flagi
        // , separator grupy, w polskim wydaniu jest spacja
        // ( negatywne znaki w nawiasach
        // komplet flag - s. 84

        // metoda statyczna String.format() nie drukuje stringa
        String message = String.format("Hello, %s!", "gulci");
        System.out.println(message);

        System.out.printf("%tc", new Date());
        System.out.println();

        // liczba po % i $ pozwalają określić, który argument formatować
        // jeden arguement można wydrukować kilka razy z różnym formatowaniem
        // istnieje flaga zero - dodawanie do liczby zer z przodu
        // dlatego argumenty indeksuje się od 1
        System.out.printf("%1$s %2$tB %2$te, %2$tY", "Due date:", new Date());

        // można też korzystać z flagi <
        // argument ma formatowanie takie, jak poprzedni
        // System.out.printf("%s %tB %<te, %<tY", "Due date:", new Date());

        // B - pełna nazwa miesiąca
        // Y - czterocyfrowy rok ze spacjami z przodu
        // e - dwucyfrowy dzień ze spacjami z przodu
        // c - kompletna data i czas

        // kolejność formatowania - schemat s. 86
        // indeks argumentu, flaga, szerokość, ew. data/czas, kropka, precyzja, typ konwersji
        // formatowanie liczb i dat jest specyficzne dla danego locale

        System.out.println();
    }
}
