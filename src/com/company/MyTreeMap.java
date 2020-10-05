package com.company;

import java.util.ArrayList;

public class MyTreeMap {

    private MyNode root;

    /**
     * Constructors
     */
    public  MyTreeMap(){
        //
    }

    public MyTreeMap(MyNode root) {
        this.root = root;
    }

    /**
     * Customs methods
     */
    public void put(String word, long line) {
        if(root != null) {
            MyNode p = root;
            if (p.getWord().compareTo(word.toLowerCase()) == 0)
                    p.addLine(line);
                else if (p.getWord().compareTo(word.toLowerCase()) < 0) {
                    if (p.getLeft() == null)
                        p.setLeft(new MyNode(word.toLowerCase()));
                    else {
                        MyTreeMap newRoot = new MyTreeMap(p.getLeft());
                        newRoot.put(word.toLowerCase(), line);
                    }
                } else if (p.getWord().compareTo(word.toLowerCase()) > 0) {
                    if (p.getRight() == null)
                        p.setRight(new MyNode(word.toLowerCase()));
                    else {
                        MyTreeMap newRoot = new MyTreeMap(p.getRight());
                        newRoot.put(word.toLowerCase(), line);
                    }
            }
        } else{
            MyNode p = new MyNode(word.toLowerCase());
            p.addLine(line);
        }
    }

    /**
     * Getters
     */
    public MyNode getRoot() {
        return root;
    }

    private class MyNode {
        private String word;
        private ArrayList<Integer> linesOfWord;
        private MyNode left;
        private MyNode right;

        /**
         * Constructor
         */
        public MyNode(String word) {
            this.word = word;
            this.linesOfWord = new ArrayList<>();
            this.left = null;
            this.right = null;
        }

        /**
         * Customs methods
         */
        public void addLine(long line){
            linesOfWord.add((int) line);
        }

        /**
         * Getters
         */
        public  String getWord(){
            return  this.word;
        }

        public MyNode getLeft() {
            return left;
        }

        public MyNode getRight() {
            return right;
        }

        /**
         * Setters
         */
        public void setLeft(MyNode left) {
            this.left = left;
        }

        public void setRight(MyNode right) {
            this.right = right;
        }
    }
}
