package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String content = "To jest przykład zdania . czasem występują błędy , ale nie zawsze .Ważne jest ,aby zadbać o poprawność tekstu .Inaczej może być trudno zrozumieć treść .Tutaj jest jeszcze jedno zdanie bez wielkiej litery na początku .Podobnie jak to ,które jest obok .Teraz nastąpi poprawne zdanie .Napisane bez błędów interpunkcyjnych .Oczywiście nie zawsze to się zdarza .Ale to nie problem .Mamy teraz 50% błędów interpunkcyjnych i braku wielkich liter.tutaj jest kolejny przykład .Przecinki i kropki są nieprawidłowo umieszczone .Jest to prawdziwe wyzwanie dla czytelnika .Kiedyś będziemy pisali lepiej .\n";

        Corrector corrector = new Corrector();
        corrector.correcting(content);
        corrector.charTooString();


    }
}