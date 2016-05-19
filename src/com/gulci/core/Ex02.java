package com.gulci.core;

public class Ex02 {
    public static void main(String[] args) {
        // main nigdy nic nie zwraca
        // jeśli chcemy coś zwrócić, to używamy static void System.exit(int status)
        // funkcja System.exit zamyka bieżącą maszynę Javy
        // System.out i System.in to standardowe wyjście/wejście, to są pola (err również)
        // in jest typu InputStream, out jest typu PrintStream (err również)
        // byte - 1 bajt
        // short - 2 bajty
        // int - 4 bajty
        // long - 8 bajtów
        // liczby long mają sufiks L lub l
        // liczby heksadecymalne mają prefiks 0x lub 0X
        // liczby oktalne mają prefiks 0
        // od JSE7 możemy zapisać liczbę binarną za pomocą prefiksu 0b lub 0B
        // od JSE7 w liczbach można dowolnie dodawać _ kompilator usuwa te znaki
        // nie ma wersji unsigned dla byte, short, int i long
        // float - 4 bajty; 6-7 cyfr znaczących
        // double - 8 bajtów; 15 cyfr znaczących
        // float używamy tylko w sytuacji, która tego wymaga
        // generalnie lepiej używać double (operacje finansowe!)
        // dla dobrej precyzji używamy klasy BigDecimal
        // float ma sufiks F lub f
        // float, który nie ma sufiksu jest traktowany jako double
        // opcjonalnie możemy używać sufiksu D lub d dla double
        // float można wyrazić heksalnie; 0.125=2^-3, 0x1.0p-3
        // dla oznaczenia wykładnika używamy p zamiast e (e jest cyfrą w hex)
        // baza 1.0 jest heksadecymalna, wykładnik jest dziesiętny
        // wartości specjalne float: +nieskończoność, -nieskończoność, NaN
        // np. dzielenie dodatniej liczby przez 0 daje +nieskończoność
        // dzielenie 0/0 lub pierwiastek z liczby ujemnej dają NaN
        // istnieją stałe Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
        // Double.NaN oraz odpowiedniki dla Float
        // w praktyce nie używamy tych wartości
        // nie możemy testować: if (x == Double.NaN) nigdy nie będzie do prawda
        // wszystkie wartości NaN są uznawane za różne od siebie
        // można testować za pomocą metody: if (Double.isNaN(x))
        // char - znaki Unicode, a dokładniej 16-bitowe code units w kodowaniu UTF-16
        // char to 2 bajty
        // niektóre znaki Unicode wymagają dwóch wartości char
        // literały, np. 'A' to stała o wartości 65 - szesnastkowo \u0041
        // code points podzielone są na 17 code planes
        // możemy zapisywać jako wartości hex od \u0000 do \uFFFF - multilingual plane, te znaki to code units
        // pozostałe code planes - od \u10000 do \u10FFFF
        // znaki z pozostałych code planes są zakodowane jako pary code units
        // w multilingual plane jest 2048 nieużywanych wartości - surrogates area
        // każdy z pary code units jest kodowany taką wartością
        // dla pierwszego code unit od \ud800 do \udbff
        // dla drugiego code unit od \udc00 do \udfff
        // dzięki temu można ocenić z jakim znakiem mamy do czynienia
        // z pojedynczym znakiem lub jedną ze składowych pary
        // np. kodowanie oktonionu (wielkie pisane O), mamy code point \u1d546
        // zakodowany za pomocą pary \ud835 oraz \udd46
        // algorytm dekodowania: https://en.wikipedia.org/wiki/UTF-16
        // char używamy tylko do manipulowania code units UTF-16
        // do pracy ze znakami lepiej używać stringa
        // dla przykładu TM i pi
        System.out.println('\u2122');
        System.out.println('\u03c0');
        // escape sequence możemy używać w stringach
        // u escape sequence można używać w '' "" oraz poza nimi
        // mamy np. dla [ i ]
        // public static void main(String\u005b\u005d args)
        // \b - \u0008
        // \t - \u0009
        // \n - \u000a
        // \r - \u000d
        // \" - \u0022
        // \' - \u0027
        // \\ - \u005c
        // sekwencje u są przetwarzane przed parsowaniem kodu
        // tutaj dostaniemy ""+"" czyli konkatenację dwóch pustych stringów
        System.out.println("\u0022+\u0022");
        // uwaga na sekwencje u w komentarzach, samo u bez czterech cyfr wywoła błąd
        // jeśli jest prawdziwa wartość po u, to zostanie ona zignorowana
        // nie konwersji między bool i int
        // if wymaga bool expression, np. x = 0 nie może być przekonwertowane do wartości bool
    }
}
