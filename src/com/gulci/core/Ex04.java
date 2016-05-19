package com.gulci.core;

public class Ex04 {
    public static void main(String[] args) {
        // stringi - sekwencje znaków Unicode
        // String to klasa w standardowej bibliotece Javy
        String greeting = "Hello!";
        // [0, 3)
        String s = greeting.substring(0, 3);
        System.out.println(s);

        int age = 13;
        // konwersja wartości nie-stringowej do string
        // każdy obiekt Javy może być przekonwertowany do String
        String rating = "PG" + age;
        System.out.println(rating);

        String all = String.join(" / ", "S", "M", "L", "XL");
        System.out.println(all);

        // nie ma metody do zmiany znaków wewnątrz stringa
        // można zmienić zawartość przez zmianę referencji do innego stringa
        // można się posłużyć substring() i konkatenacją

        // stringi są współdzielone (tak działa wirtualna maszyna)
        // wszystkie stringi znajdują się w jedny miejscu (pool)
        // zmienne typu String wskazują wtedy na miejsce w pool
        // kopiowanie stringa oznacza przypisanie referencji do tego samego stringa

        // wszystko w "" jest traktowane jako obiekt typu String
        // możemy porównywać zmienne lub literały
        System.out.println("Hello".equals("hello"));
        System.out.println("Hello".equalsIgnoreCase("hello"));

        // == testuje lokację w pamięci zmiennej
        // współdzielona jest zawartość zmiennej i literały, a nie wynik operacji + lub substring()
        String compstr = "compare";
        if (compstr == "compare") {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }

        if (compstr.substring(0, 3) == "com") {
            System.out.println("equals substring");
        } else {
            System.out.println("not equals substring");
        }

        // oba stringi zawierają referencję do tego samego miejsca w pamięci
        String comp1 = "yol";
        String comp2 = comp1;
        if (comp1 == comp2) {
            System.out.println("equals comp");
        } else {
            System.out.println("not equals comp");
        }

        // porównanie leksykograficzne
        // int, różnica w charAt() dla pierwszego indeksu z różnicą
        System.out.println("hello".compareTo("Hello"));
        // jeśli nie ma różnicy, to porównywana jest długość
        // int, różnica długości, będzie 0
        System.out.println("hello".compareToIgnoreCase("Hello"));
        System.out.println((int) "hello".charAt(0));
        System.out.println((int) "Hello".charAt(0));
        System.out.println("hello".charAt(0) - "Hello".charAt(0));

        // string może być null
        String nullstr = null;
        // nullstr.equals("")
        if (nullstr != null && nullstr.length() != 0) {
            // trzeba najpierw testować null, wywołanie metody na wartości null da błąd
        }

        String china = "Hello\ud852\udf62";
        System.out.println(china);

        // length() liczy code units
        System.out.println("length " + china.length());
        // liczba code points
        // drugi argument - indeks po ostatnim znaku
        int cpCount = china.codePointCount(0, china.length());
        System.out.println("cps " + cpCount);

        // code unit na danej pozycji
        System.out.println("first " + china.charAt(0));
        // to są znaki z surrogates area, pokazuje się ?
        System.out.println("last " + china.charAt(china.length() - 1));
        System.out.println("last " + china.charAt(china.length() - 2));

        // i-ty code point
        int index = china.offsetByCodePoints(0, cpCount - 1);
        int cp = china.codePointAt(index);
        System.out.println("cp " + cp);

        System.out.println(Character.isSurrogate(china.charAt(index)) + " " + index);
        System.out.print(Character.isSurrogate(china.charAt(china.length() - 2)));
        System.out.println(" " + (china.length() - 2));
        System.out.print(Character.isSurrogate(china.charAt(china.length() - 1)));
        System.out.println(" " + (china.length() - 1));

        System.out.println(Character.isSupplementaryCodePoint(china.charAt(index)) + " " + index);
        System.out.print(Character.isSupplementaryCodePoint(china.charAt(china.length() - 2)));
        System.out.println(" " + (china.length() - 2));
        System.out.print(Character.isSupplementaryCodePoint(china.charAt(china.length() - 1)));
        System.out.println(" " + (china.length() - 1));

        int[] codePoints = china.codePoints().toArray();
        for (int i = 0; i < codePoints.length; i ++) {
            // rzutowanie na char code point, który nie jest prostym code unit da kiepski rezultat
            System.out.println((char) codePoints[i]);
        }
        String cpString = new String(codePoints, 0, codePoints.length);
        System.out.println(cpString);

        // powtórzyć przykład z isSupplementaryCodePoint i isSurrogate
        // s. 71 - 3.6.7 The String API
    }
}
