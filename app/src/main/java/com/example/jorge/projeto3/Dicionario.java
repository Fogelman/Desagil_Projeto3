package com.example.jorge.projeto3;

import java.util.LinkedList;

public class Dicionario {

    public LinkedList<LinkedList<String>> getDicionario(){
        Translator trans = new Translator();
        String alfa = "abcdefghijklmnopqrstuvwxyz0123456789";
        LinkedList<String> alfabeto = new LinkedList<>();
        LinkedList<String> morseAlfa = new LinkedList<>();
        for (int i =0;i<alfa.length();i++) {
            alfabeto.add(Character.toString(alfa.charAt(i)));
            morseAlfa.add(trans.charToMorse(alfa.charAt(i)));
        }
        LinkedList<LinkedList<String>> tudo = new LinkedList<>();
        tudo.add(alfabeto);
        tudo.add(morseAlfa);
        return tudo;


    }
}
