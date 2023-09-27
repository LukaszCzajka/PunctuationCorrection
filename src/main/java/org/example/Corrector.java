package org.example;

import java.util.ArrayList;
import java.util.List;

public class Corrector {

    String correctedContent = "";
    List<Character> listOfLetterContent = new ArrayList<>();

    public void correcting(String content){
        toList(content);
        deleteLastDot();// jeśli ostatni znak listy / wprowadzonego tekstu jest , lub . - usuwamy go
                        // jeśli tego nie usuniemy metody poniżej pokażą błędy ponieważ próbują uzyskać dostęp do indeksu i+2, który w przypadku gdy '.' jest na końcu wychodzi poza granice listy
        deleteSpaces();
        addSpaceAfter();
        changeToCapitalLetter();
    }

    //zmiana stinga na liste char
    public void toList(String content){
        for (char c : content.toCharArray()) {
            listOfLetterContent.add(c);
        }
    }

    //usunięcie . jako ostniego elementu Stringa
    public void deleteLastDot(){
        if (listOfLetterContent.get(listOfLetterContent.size()-1) == '.' || listOfLetterContent.get(listOfLetterContent.size()-1) == ','){
            listOfLetterContent.remove(listOfLetterContent.size()-1);
            deleteLastDot();
        }
    }

    //usunięcie spacji przed i po znakach , || .
    public void deleteSpaces(){//usunięcie spacji przed znakiem , || .
        for (int i = 0; i < listOfLetterContent.size(); i++){
            char currentChar = listOfLetterContent.get(i);
           // char lastElement = listOfLetterContent.get(listOfLetterContent.size()-1);

            if ((currentChar == ',' || currentChar == '.') && listOfLetterContent.get(i-1) == ' ' ){
                //sprawdza czy znak przed , lub . jest spacją
                //jeśli tak, usuń
                listOfLetterContent.remove(i-1);
                i-=2; // ustawia i pętli po całej liscie -2 aby sprawdzić czy nie ma więcej niż 1 spacji
            } else if ((currentChar == ',' || currentChar == '.') && listOfLetterContent.get(i+2) == ' '){
                //sprawdza czy drugi znak po , lub . jest spacją
                //jeśli tak, usuń
                listOfLetterContent.remove(i + 2);
                i-=2; // ustawia i pętli po całej liscie -2 aby sprawdzić czy nie ma więcej niż 1 spacji
            }
        }
    }

    //dodanie spacji po znaku , || .
    public void addSpaceAfter(){
        for (int i = 0; i < listOfLetterContent.size(); i++){
            char currentChar = listOfLetterContent.get(i);
            if ((currentChar == ',' || currentChar == '.') && listOfLetterContent.get(i+1) != ' '){
                //sprawdza, czy znak jest , || . oraz czy następny znak(i+1) znak != spacja
                //jeśli nie, dodaje spacje
                listOfLetterContent .add(i+1, ' ');
            }
        }
    }

    //Zamiana litery na wielką po '.'
    public void changeToCapitalLetter(){
        for (int i = 0; i < listOfLetterContent.size(); i++){
            char currentChar = listOfLetterContent.get(i);

            if (currentChar == '.'){
                char upperChar = Character.toUpperCase(listOfLetterContent.get(i+2));
                listOfLetterContent.set(i+2, upperChar);
            }
        }
    }

    public String charTooString(){
        for (Character c : listOfLetterContent){
            correctedContent += c;
        }
        return correctedContent;
    }

}
