package org.example;

import java.util.ArrayList;
import java.util.List;

public class Corrector {

    String correctedContent = "";
    List<Character> listOfLetterContent = new ArrayList<>();

    public void correcting(String content){
        toList(content);
        for (int i = 0; i < listOfLetterContent.size() -2; i++){ // pomniejszamy iteracje o rozmiar listy -2
            //jeśli tego nie zrobimy metody poniżej pokażą błędy ponieważ próbują uzyskać dostęp do indeksu i+2, który w przypadku gdy '.' jest na końcu wychodzi poza granice listy
            i = deleteSpaces(i); // ustawia i-=2 żeby sprawdzić czy nie ma więcej spacji
            addSpaceAfter(i);
            changeToCapitalLetter(i);
        }
    }

    //zmiana stinga na liste char
    public void toList(String content){
        for (char c : content.toCharArray()) {
            listOfLetterContent.add(c);
        }
    }

    //usunięcie spacji przed i po znakach , || .
    public int deleteSpaces(int i){
            char currentChar = listOfLetterContent.get(i);
            if ((currentChar == ',' || currentChar == '.') && listOfLetterContent.get(i-1) == ' ' ){
                //sprawdza czy znak przed , lub . jest spacji - jeśli tak, usuń
                listOfLetterContent.remove(i-1);
                i-=2; // ustawia i do zwrócenia w pętli po całej liscie w metodzie correcting. -2 aby sprawdzić czy nie ma więcej niż 1 spacji
            } else if ((currentChar == ',' || currentChar == '.') && listOfLetterContent.get(i+2) == ' '){
                //sprawdza czy drugi znak po , lub . jest spacją
                //jeśli tak, usuń
                listOfLetterContent.remove(i + 2);
                i-=2; // ustawia i do zwrócenia w pętli po całej liscie w metodzie correcting +2 aby sprawdzić czy nie ma więcej niż 1 spacji
            } else if (currentChar == ' ' && listOfLetterContent.get(i-1) == ' ' ){
                //usuwa zdublowane spacje między którymi nie ma interpunkcji
                listOfLetterContent.remove(i-1);
                i-=2; // ustawia i pętli po całej liscie -2 aby sprawdzić czy nie ma więcej niż 1 spacji
            }
        return i;
    }

    //dodanie spacji po znaku , || .
    public void addSpaceAfter(int i){
        //for (int i = 0; i < listOfLetterContent.size() - 2; i++){
            char currentChar = listOfLetterContent.get(i);
            if ((currentChar == ',' || currentChar == '.') && listOfLetterContent.get(i+1) != ' '){
                //sprawdza, czy znak jest , || . oraz czy następny znak(i+1) znak != spacja
                //jeśli nie, dodaje spacje
                listOfLetterContent .add(i+1, ' ');
            }
       // }
    }

    //Zamiana litery na wielką po '.'
    public void changeToCapitalLetter(int i){
       // for (int i = 0; i < listOfLetterContent.size() - 2; i++){
            char currentChar = listOfLetterContent.get(i);

            if (currentChar == '.'){
                char upperChar = Character.toUpperCase(listOfLetterContent.get(i+2));
                listOfLetterContent.set(i+2, upperChar);
            }
       // }
    }

    public String charTooString(){
        for (Character c : listOfLetterContent){
            correctedContent += c;
        }
        return correctedContent;
    }

}
