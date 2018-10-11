package com.example.jorge.projeto3;


import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

// ESTA CLASSE NÃO PODE SER MODIFICADA!
public class TranslatorTest {
    private Translator translator;

    @Before
    public void setUp() {
        translator = new Translator();
    }

    @Test
    public void toA() {
        assertEquals('a', translator.morseToChar(".-"));
    }

    @Test
    public void toB() {
        assertEquals('b', translator.morseToChar("-..."));
    }

    @Test
    public void toC() {
        assertEquals('c', translator.morseToChar("-.-."));
    }

    @Test
    public void toD() {
        assertEquals('d', translator.morseToChar("-.."));
    }

    @Test
    public void toE() {
        assertEquals('e', translator.morseToChar("."));
    }

    @Test
    public void toF() {
        assertEquals('f', translator.morseToChar("..-."));
    }

    @Test
    public void toG() {
        assertEquals('g', translator.morseToChar("--."));
    }

    @Test
    public void toH() {
        assertEquals('h', translator.morseToChar("...."));
    }

    @Test
    public void toI() {
        assertEquals('i', translator.morseToChar(".."));
    }

    @Test
    public void toJ() {
        assertEquals('j', translator.morseToChar(".---"));
    }

    @Test
    public void toK() {
        assertEquals('k', translator.morseToChar("-.-"));
    }

    @Test
    public void toL() {
        assertEquals('l', translator.morseToChar(".-.."));
    }

    @Test
    public void toM() {
        assertEquals('m', translator.morseToChar("--"));
    }

    @Test
    public void toN() {
        assertEquals('n', translator.morseToChar("-."));
    }

    @Test
    public void toO() {
        assertEquals('o', translator.morseToChar("---"));
    }

    @Test
    public void toP() {
        assertEquals('p', translator.morseToChar(".--."));
    }

    @Test
    public void toQ() {
        assertEquals('q', translator.morseToChar("--.-"));
    }

    @Test
    public void toR() {
        assertEquals('r', translator.morseToChar(".-."));
    }

    @Test
    public void toS() {
        assertEquals('s', translator.morseToChar("..."));
    }

    @Test
    public void toT() {
        assertEquals('t', translator.morseToChar("-"));
    }

    @Test
    public void toU() {
        assertEquals('u', translator.morseToChar("..-"));
    }

    @Test
    public void toV() {
        assertEquals('v', translator.morseToChar("...-"));
    }

    @Test
    public void toW() {
        assertEquals('w', translator.morseToChar(".--"));
    }

    @Test
    public void toX() {
        assertEquals('x', translator.morseToChar("-..-"));
    }

    @Test
    public void toY() {
        assertEquals('y', translator.morseToChar("-.--"));
    }

    @Test
    public void toZ() {
        assertEquals('z', translator.morseToChar("--.."));
    }

    @Test
    public void to0() {
        assertEquals('0', translator.morseToChar("-----"));
    }

    @Test
    public void to1() {
        assertEquals('1', translator.morseToChar(".----"));
    }

    @Test
    public void to2() {
        assertEquals('2', translator.morseToChar("..---"));
    }

    @Test
    public void to3() {
        assertEquals('3', translator.morseToChar("...--"));
    }

    @Test
    public void to4() {
        assertEquals('4', translator.morseToChar("....-"));
    }

    @Test
    public void to5() {
        assertEquals('5', translator.morseToChar("....."));
    }

    @Test
    public void to6() {
        assertEquals('6', translator.morseToChar("-...."));
    }

    @Test
    public void to7() {
        assertEquals('7', translator.morseToChar("--..."));
    }

    @Test
    public void to8() {
        assertEquals('8', translator.morseToChar("---.."));
    }

    @Test
    public void to9() {
        assertEquals('9', translator.morseToChar("----."));
    }

    @Test
    public void fromA() {
        assertEquals(".-", translator.charToMorse('a'));
    }

    @Test
    public void fromB() {
        assertEquals("-...", translator.charToMorse('b'));
    }

    @Test
    public void fromC() {
        assertEquals("-.-.", translator.charToMorse('c'));
    }

    @Test
    public void fromD() {
        assertEquals("-..", translator.charToMorse('d'));
    }

    @Test
    public void fromE() {
        assertEquals(".", translator.charToMorse('e'));
    }

    @Test
    public void fromF() {
        assertEquals("..-.", translator.charToMorse('f'));
    }

    @Test
    public void fromG() {
        assertEquals("--.", translator.charToMorse('g'));
    }

    @Test
    public void fromH() {
        assertEquals("....", translator.charToMorse('h'));
    }

    @Test
    public void fromI() {
        assertEquals("..", translator.charToMorse('i'));
    }

    @Test
    public void fromJ() {
        assertEquals(".---", translator.charToMorse('j'));
    }

    @Test
    public void fromK() {
        assertEquals("-.-", translator.charToMorse('k'));
    }

    @Test
    public void fromL() {
        assertEquals(".-..", translator.charToMorse('l'));
    }

    @Test
    public void fromM() {
        assertEquals("--", translator.charToMorse('m'));
    }

    @Test
    public void fromN() {
        assertEquals("-.", translator.charToMorse('n'));
    }

    @Test
    public void fromO() {
        assertEquals("---", translator.charToMorse('o'));
    }

    @Test
    public void fromP() {
        assertEquals(".--.", translator.charToMorse('p'));
    }

    @Test
    public void fromQ() {
        assertEquals("--.-", translator.charToMorse('q'));
    }

    @Test
    public void fromR() {
        assertEquals(".-.", translator.charToMorse('r'));
    }

    @Test
    public void fromS() {
        assertEquals("...", translator.charToMorse('s'));
    }

    @Test
    public void fromT() {
        assertEquals("-", translator.charToMorse('t'));
    }

    @Test
    public void fromU() {
        assertEquals("..-", translator.charToMorse('u'));
    }

    @Test
    public void fromV() {
        assertEquals("...-", translator.charToMorse('v'));
    }

    @Test
    public void fromW() {
        assertEquals(".--", translator.charToMorse('w'));
    }

    @Test
    public void fromX() {
        assertEquals("-..-", translator.charToMorse('x'));
    }

    @Test
    public void fromY() {
        assertEquals("-.--", translator.charToMorse('y'));
    }

    @Test
    public void fromZ() {
        assertEquals("--..", translator.charToMorse('z'));
    }

    @Test
    public void from0() {
        assertEquals("-----", translator.charToMorse('0'));
    }

    @Test
    public void from1() {
        assertEquals(".----", translator.charToMorse('1'));
    }

    @Test
    public void from2() {
        assertEquals("..---", translator.charToMorse('2'));
    }

    @Test
    public void from3() {
        assertEquals("...--", translator.charToMorse('3'));
    }

    @Test
    public void from4() {
        assertEquals("....-", translator.charToMorse('4'));
    }

    @Test
    public void from5() {
        assertEquals(".....", translator.charToMorse('5'));
    }

    @Test
    public void from6() {
        assertEquals("-....", translator.charToMorse('6'));
    }

    @Test
    public void from7() {
        assertEquals("--...", translator.charToMorse('7'));
    }

    @Test
    public void from8() {
        assertEquals("---..", translator.charToMorse('8'));
    }

    @Test
    public void from9() {
        assertEquals("----.", translator.charToMorse('9'));
    }

    @Test
    public void bfs() {
        String[] gold = new String[]{
                ".",
                "-",
                "..",
                ".-",
                "-.",
                "--",
                "...",
                "..-",
                ".-.",
                ".--",
                "-..",
                "-.-",
                "--.",
                "---",
                "....",
                "...-",
                "..-.",
                ".-..",
                ".--.",
                ".---",
                "-...",
                "-..-",
                "-.-.",
                "-.--",
                "--..",
                "--.-",
                ".....",
                "....-",
                "...--",
                "..---",
                ".----",
                "-....",
                "--...",
                "---..",
                "----.",
                "-----",
        };

        LinkedList<String> codes = translator.getCodes();

        int i = 0;

        for(String code: codes) {
            assertEquals(gold[i], code);

            i++;
        }
    }
}




