package org.example;

public class Main {
    public static void main(String[] args) {

        String content = "To jest  przykład      zdania            ,             123.  test.kropka      sa. To jest przykład poprawnego zdania. to  jest już inne  ,  przecinek sie tu nie zgadza i kropka tez .zaczynamy od wielkiej litery.";

        Corrector corrector = new Corrector();
        corrector.correcting(content);
        System.out.println(corrector.charTooString());
    }
}