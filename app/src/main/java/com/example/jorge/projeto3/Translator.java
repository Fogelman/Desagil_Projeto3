package com.example.jorge.projeto3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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
        map = new HashMap<>();
//        String alfa = " ETIANMSURWDKGOHVF L PJBXCYZQ  54 3   2  +    16=/     7   8 90";
        String alfa = " etianmsurwdkgohvf l pjbxcyzq  54 3   2       16       7   8 90";
        Node[] nodes = new Node[alfa.length()];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(alfa.charAt(i));
            if (alfa.charAt(i) != ' ') {
                this.map.put(alfa.charAt(i), nodes[i]);
            }
        }
        this.root = nodes[0];

        for (int i = 0; i < nodes.length; i++) {

            if (nodes[i] != root) {
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

        Node node = this.root;
        for (int i =0; i<code.length();i++){

            if (code.charAt(i)=='.'){
                node = node.getLeftChild();
            }
            else if (code.charAt(i)=='-'){
                node = node.getRightChild();
            }
        }

        return node.getValue();
    }


    // ESTE MÉTODO DEVE SER PREENCHIDO DE ACORDO COM O ENUNCIADO!
    public String charToMorse(char c) {


        String code = "";
        Node node = this.map.get(c);

        if (node != null) {
            while (node != this.root ) {

                Node oldNode = node;
                node = node.getParent();

                if (node.getLeftChild() == oldNode) {
                    code = "." + code;
                } else if (node.getRightChild() == oldNode) {
                    code = "-" + code;

                }
            }


            return code;
        }
        else{

            return null;
        }
    }


    // ESTE MÉTODO DEVE SER PREENCHIDO DE ACORDO COM O ENUNCIADO!
    public LinkedList<String> getCodes() {

        LinkedList<String> codes = new LinkedList<String>();
        LinkedList<Node> visited = new LinkedList<Node>();
        LinkedList<Node> queue = new LinkedList<Node>();

        visited.add(root);
        queue.addLast(root);

        while (!queue.isEmpty()){
            Node node = queue.getFirst();
            Node left = node.getLeftChild();
            Node right = node.getRightChild();

            if(left != null && !visited.contains(left)){
                visited.addLast(left);
                queue.addLast(left);
            }
            else if(right != null && !visited.contains(right)){
                visited.addLast(right);
                queue.addLast(right);
            }

            else{

                queue.removeFirst();

                if (node.getValue() != ' '){
                    codes.addLast(String.valueOf(charToMorse(node.getValue())));
                }


            }


        }

        return codes;
    }
}