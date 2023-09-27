package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String content = "To jest przykład zdania    ,              123 . test";

        Corrector corrector = new Corrector();
        corrector.correcting(content);
        System.out.println(corrector.charTooString());

        //,trim() - usunięcie spacji z końca i początku

    }
}