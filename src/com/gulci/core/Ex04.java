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
        // generalnie, jeśli stringi się nie różnią, wynik będzie 0
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

        // sout + tab
        // shift + enter - nowa linia after
        // ctrl + alt + enter - nowa linia before
        // ctrl + d - duplikacja linii lub zaznaczonego fragmentu
        // ctrl + y - usunięcie linii
        // shift + alt + up/down - przesunięcie linii
        // shift + ctrl + up/down - przesunięcie bloku

        // i-ty code point; nasz cp jest w tym przypadku na końcu
        int index = china.offsetByCodePoints(0, cpCount - 1);
        int cp = china.codePointAt(index);
        System.out.println("cp " + cp);

        // sprawdzanie czy code unit jest surogatem, jedną z dwóch części code point
        System.out.println(Character.isSurrogate(china.charAt(index)) + " " + index);
        System.out.print(Character.isSurrogate(china.charAt(china.length() - 2)));
        System.out.println(" " + (china.length() - 2));
        System.out.print(Character.isSurrogate(china.charAt(china.length() - 1)));
        System.out.println(" " + (china.length() - 1));

        // sprawdzanie czy dany znak jest niestandardowym znakiem
        System.out.print(Character.isSupplementaryCodePoint(china.codePointAt(index)));
        System.out.println(" " + index);
        System.out.println(Character.isSupplementaryCodePoint(china.codePointAt(0)) + " 0");

        int[] codePoints = china.codePoints().toArray();
        for (int i = 0; i < codePoints.length; i++) {
            // toChars() zwraca tablicę (dwa code unit dla code point)
            // char jest zbyt low-level
            // potrzebujemy stringa, gdyż mamy dwa znaki w tablicy
            // a przy konkatenacji są one błędnie odczytywane
            // bez konkatenacji jest ok
            // potrzebujemy obiektu String, nie wystarczy toString() na tablicy
            System.out.print(codePoints[i] + ": " + new String(Character.toChars(codePoints[i])));

            if (Character.isSupplementaryCodePoint(codePoints[i])) {
                System.out.println(" supplementary code point");
            } else {
                System.out.println(" code unit");
            }
        }

        String cpString = new String(codePoints, 0, codePoints.length);
        System.out.println(cpString);

        int j = 0;
        while (j < china.length()) {
            if (Character.isSurrogate(china.charAt(j))) {
                int indexCodePoint = china.offsetByCodePoints(0, j);
                int codePoint = china.codePointAt(indexCodePoint);
                System.out.print(Character.toChars(codePoint));

                if (Character.isSupplementaryCodePoint(codePoint)) {
                    System.out.println(" supplementary code point");
                }

                j += 2;
            } else {
                System.out.println(china.charAt(j));
                j++;
            }
        }

        // jest też metoda endsWith()
        System.out.println("starts with H: " + china.startsWith("H"));

        // różne wersje indexOf() - z punktem startowym i z code points
        // podobnie z lastIndexOf()
        System.out.println("first index of l: " + china.indexOf("l"));
        System.out.println("last index of l: " + china.lastIndexOf("l"));

        // argumenty są typu CharSequence, jest to interfejs
        // można użyć typów String lub StringBuilder
        // zwraca cały nowy string, oryginalny string pozostaje niezmieniony
        System.out.println("replace for happy: " + china.replace("ello", "appy"));

        // możliwość podania locale
        System.out.println(china.toLowerCase());
        System.out.println(china.toUpperCase());

        System.out.println("=" + " hola! ".trim() + "=");

        // przy każdej konkatenacji stringa powstaje nowy obiekt w pamięci, co jest nieefektywne
        // używamy klasy StringBuilder, od JDK5
        // wcześniej był StringBuffer, mniej efektywny
        // ale umożliwiał edycję stringa różnym wątkom
        // w StringBuilder edycja stringa ma miejsce w jednym wątku
        // API obu klas są identyczne
        StringBuilder builder = new StringBuilder();
        // append() zwraca this
        // jest też appendCodePoint(), code point jest konwertowany do code units
        builder.append('H');
        builder.append("ello");

        // liczba code units
        System.out.println("builder length: " + builder.length());

        // nic nie zwraca
        builder.setCharAt(1, 'a');

        // zwraca this, jest wersja dla char, string i wielu innych
        builder.insert(1, "aaa");

        // zwraca this, [startIndex, endIndex)
        builder.delete(1, 2);

        String completedString = builder.toString();
        System.out.println("builded string: " + completedString);
    }
}
