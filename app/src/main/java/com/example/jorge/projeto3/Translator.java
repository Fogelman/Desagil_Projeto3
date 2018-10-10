package com.example.jorge.projeto3;

import java.util.HashMap;
import java.util.LinkedList;

public class Translator {
    // ESTA CLASSE NÃO PODE SER MODIFICADA!
    private class Node {
        private char value;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        public Node() {
            this.value = ' ';
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }
        public Node(char value) {
            this.value = value;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }

        public char getValue() {
            return value;
        }
        public Node getParent() {
            return parent;
        }
        public void setParent(Node parent) {
            this.parent = parent;
        }
        public Node getLeftChild() {
            return leftChild;
        }
        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }
        public Node getRightChild() {
            return rightChild;
        }
        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }


    // ESTE CONJUNTO DE ATRIBUTOS NÃO PODE SER MODIFICADO, OU
    // SEJA, NÃO É PERMITIDO ADICIONAR NEM REMOVER ATRIBUTOS!
    private Node root;
    private HashMap<Character, Node> map;


    // ESTE CONSTRUTOR DEVE SER PREENCHIDO DE ACORDO COM O ENUNCIADO!
    public Translator() {
        String alfa = " ETIANMSURWDKGOHVF L PJBXCYZQ  54 3   2  +    16=/     7   8 90";
        Node[] nodes = new Node[alfa.length()];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(alfa.charAt(i));
            if (alfa.charAt(i) != ' ') {
                this.map.put(alfa.charAt(i), nodes[i]);
            }
        }
        this.root = nodes[0];

        for (int i = 0; i < nodes.length; i++) {

            if (nodes[i] == root) {
                nodes[i].setParent(nodes[(i-1)/2]);
            }

            if ((2*i+1) < nodes.length) {
                nodes[i].setLeftChild(nodes[2*i+1]);
            }

            if ((2*i+2) < nodes.length) {
                nodes[i].setRightChild(nodes[2*i+2]);
            }
        }
    }


    // ESTE MÉTODO DEVE SER PREENCHIDO DE ACORDO COM O ENUNCIADO!
    public char morseToChar(String code) {
        return ' ';
    }


    // ESTE MÉTODO DEVE SER PREENCHIDO DE ACORDO COM O ENUNCIADO!
    public String charToMorse(char c) {
        return null;
    }


    // ESTE MÉTODO DEVE SER PREENCHIDO DE ACORDO COM O ENUNCIADO!
    public LinkedList<String> getCodes() {
        return null;
    }
}