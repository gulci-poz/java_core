package com.gulci.core;

public class Ex03 {
    // stała klasy, dostępna dla wszystkiech metod w klasie
    // przez public stała jest dostępna dla innych klas
    // const to słowo kluczowe w Javie, ale nie jest obecnie do niczego wykorzystywane
    public static final double MY_CLASS_CONST = 0.1234;

    // typu wyliczeniowego nie można definiować lokalnie w metodzie
    enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE};

    public static void main(String[] args) {
        // identyfikacja "znaku" ("litery" lub "cyfry") dla nazwy zmiennej
        // Start - czy litera może wystąpić jako pierwsza w nazwie
        // Part - czy litera może wystąpić jako dowolna kolejna po pierwszej literze
        // argumentem w przypadku obu funkcji może być char lub code point w postaci int
        // zwraca bool
        // Character.isJavaIdentifierStart
        // Character.isJavaIdentifierPart

        System.out.println(Character.isJavaIdentifierStart('1'));
        System.out.println(Character.isJavaIdentifierPart('1'));

        // można deklarować zmienne w jednej linii, ale jest to mało czytelne
        int i, j;
        // zmienne muszą być zainicjowane, użycie bez inicjalizacji wywoła błąd
        i = 10;
        j = 20;
        System.out.println(i + j);

        // deklaracja i inicjalizacja
        // deklaracja zmiennej możliwie blisko miejsca pierwszego użycia
        int vacationDays = 26;
        System.out.println(vacationDays);

        // stała, możemy tylko raz przypisać wartośc
        final double MY_PI = 3.14;
        System.out.println(MY_PI);
        System.out.println(MY_CLASS_CONST);

        // dzielenie całkowite - oba argumenty są int
        // dzielenie przez 0 daje błąd
        // dzielenie rzeczywiste - oba argumenty są float
        // dzielenie przez 0 - nieskończonośc lub NaN (0.0/0.0)
        System.out.println(4.0 / 0.0);
        System.out.println(0.0 / 0.0);

        // domyślnie dozwolone jest używanie rozszerzonej precyzji przez procesor
        // np. double w = x * y / z
        // mnożenie jest zapisywane w 80-bit rejestrze, po dzieleniu wynik jest zaokrąglany
        // można oznaczyć metodę słówkiem strictfp (można też klasę)
        // wtedy operacje będa wykonywane z precyzją określoną przez typ danych (64-bit dla double)
        System.out.println(useExtended(1.999999988888888, 5.1828384877777777, 6.123456789));
        System.out.println(useDefault(1.999999988888888, 5.1828384877777777, 6.123456789));

        // procesory intela korzystają z rozszerzonego wykładnika
        // mantysa jest zaokrąglana bez straty wydajności
        // ścisłe obliczenia (strictfp) mogą dać overflow, ale domyślne nie

        System.out.println(Math.sqrt(4));
        System.out.println(Math.pow(2, 16));

        System.out.println(10 % 2);
        System.out.println(9 % 2);
        // dla liczb ujemnych dostaniemy -1, zasada utrzymywanie reszty >= 0
        System.out.println(-5 % 2);

        // dostaniemy dodatnią resztę
        System.out.println(Math.floorMod(1 - 10, 12));

        // dla ujemnych dzielników dostaniemy ujemny wynik
        System.out.println(Math.floorMod(10, -13));

        // import static java.lang.Math.*;
        // Math.sin()
        // Math.cos()
        // Math.tan()
        // Math.atan() - wartość kąta [-pi/2, pi/2]
        // Math.atan2() - kąt theta po rozwinięciu do współrzędnych polarnych
        // Math.exp() - e do potęgi <argument double>
        // Math.log()
        // Math.log10()
        System.out.println(Math.PI);
        System.out.println(Math.E);

        // Math używa FPU procesora dla wydajności
        // jeśli liczy się przewidywalność wyniku, to możemy skorzystać z klasy StrictMath
        // korzysta ona z algorytmów z Freely Distributable Math Library fdlibm
        // takie same wyniki dla różnych platform
        // kod źródłowy algorytmów: http://www.netlib.org/fdlibm/

        // legalne konwersje
        // byte -> short -> int -> long
        // char -> int
        // float -> double
        // int --> float (utrata precyzji)
        // int -> double
        // long --> float (utrata precyzji)
        // long --> double (utrata precyzji)
        int n = 123456789;
        float f = n;
        System.out.println(f);

        // w przypadku operatora binarnego (np. +) obie wartości są konwertowane do wspólnego typu
        // przed wykonaniem operacji
        // jeśli mamy double - drugi będzie double
        // w przeciwnym wypadku, jeśli mamy float - drugi będzie float
        // w przeciwnym wypadku, jeśli mamy long - drugi będzie long
        // w przeciwnym wypadku - oba składniki będą przekonwertowane do int

        // casts - konwersje, w którym możliwa jest strata informacji

        // ignorowanie części ułamkowej
        double x = 9.997;
        int nx = (int) x;
        System.out.println(nx);

        // zaokrąglenie do long, również konieczna jest jawna konwersja
        // możliwa utrata informacji z long do int
        int nx_rounded = (int) Math.round(x);
        System.out.println(nx_rounded);

        // byte nie ma wystarczającego zakresu, konwersja jest robiona modulo
        byte bx = (byte) 300;
        System.out.println(bx);

        int nval = 3;
        // tutaj int nval jest konwertowany automatycznie do float i wynik mamy we float
        System.out.println(nval + 3.5);
        // w wyniku mamy float, ale przypisujemy go do int
        // jest za nas robiona konwersja (cast) do int, przez co mamy obciętą część ułamkową
        nval += 3.5;
        System.out.println(nval);

        // inkrementacja/dekrementacja o 1, różne działanie w wyrażeniem
        // nie zaleca się używania tej notacji w wyrażeniach

        int a = 7;
        int b = 7;
        // dodawanie przed wykonaniem wyrażenia
        int ra = 2 * ++a;
        // dodawanie po wykonaniu wyrażenia
        int rb = 2 * b++;
        System.out.println(ra + ", " + a);
        System.out.println(rb + ", " + b);

        // unarny operator zaprzeczenia
        if (!false) {
            System.out.println("true");
        }

        if (a != 0 && 1 / a > a + b) {
            System.out.println("wow");
        } else {
            System.out.println("wykorzystanie && do upewnienia się, że nie będziemy dzielili przez 0");
        }

        // operator ternarny
        // "konwersja" boolean do int
        boolean boolx = true;
        System.out.println(boolx ? 1 : 0);

        // operatory bitowe
        // aplikowane do boolean dają wartość typu boolean
        // nie działają w trybie "short circuit"
        // w przeciwieństwie do && i || oba argumenty są obliczane
        // & and
        // | or
        // ^ xor
        // ~ not
        // << i >>
        // różnice dla liczb ujemnych
        // >> rozszerza sign bit do top bits (przesunięcie arytmetyczne)
        // >>> wypełnia top bits zerami (przesunięcie logiczne)
        // nie ma operatora <<<
        // prawostronny argument shift jest redukowany modulo 32
        // jesli lewostronny argument jest long, to mamy redukcję modulo 64
        // ten sam rezultat 1 << 35, 1 << 3, 1 << 8
        int bitnum = 169;
        // int bitnum = 0b10101001;
        // technika maskowania
        // sprawdzenie czy czwarty znak od prawej to 1
        int fourthBitFromRight = (bitnum & 0b1000) / 0b1000;
        // to samo można zapisać za pomocą przesunięcia
        // int fourthBitFromRight = (bitnum & (1 << 3)) >> 3;
        System.out.println(fourthBitFromRight);

        // mamy jeszcze unarne operatory + i -
        // s. 64 - tabela kolejności działań
        // nie ma operatora ,
        // można używać , w for w pierwszej i trzeciej sekcji

        // s może mieć też wartość null - zmienna nie jest ustawiona na żadną wartość
        Size s = Size.MEDIUM;
        System.out.println(s);
    }

    public static double useExtended(double num1, double num2, double num3) {
        return num1 / num2 * num3;
    }

    public static strictfp double useDefault(double num1, double num2, double num3) {
        return num1 / num2 * num3;
    }
}
