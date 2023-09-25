package org.example;

import java.util.ArrayList;
import java.util.List;

public class Corrector {

    String correctedContent = "";
    List<Character> listOfLetterContent = new ArrayList<>();

    public void correcting(String content){
        toList(content);
        deleteSpaceBefore();
        addSpaceAfter();
        changeToCapitalLetter();
    }

    //zmiana stinga na liste char
    public void toList(String content){
        for (char c : content.toCharArray()) {
            listOfLetterContent.add(c);
        }
    }

    //usunięcie spacji przed znakiem , || .
    public void deleteSpaceBefore(){//usunięcie spacji przed znakiem , || .
        for (int i = 0; i < listOfLetterContent.size(); i++){
            char currentChar = listOfLetterContent.get(i);
            if ((currentChar == ',' || currentChar == '.') && listOfLetterContent.get(i-1) == ' ' ){
                //sprawdza, czy znak jest , || . oraz czy poprzedzający znak(i-1) == spacja
                //jeśli tak, usuń
                listOfLetterContent.remove(i-1);
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

    public void charTooString(){
        for (Character c : listOfLetterContent){
            correctedContent += c;
        }
        System.out.println(correctedContent);
    }

}
