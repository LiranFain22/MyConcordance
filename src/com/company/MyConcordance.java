package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyConcordance {

    public static void main(String[] args) {
        System.out.print("Enter the FULL PATH file with extension : ");
        Scanner scanner = new Scanner(System.in);
        String pathFile = scanner.nextLine();
        readFile(pathFile);
    }

    public static void readFile(String pathFile) {
//        try {
//            System.out.print("Enter the FULL PATH file with extension : ");
//            Scanner scanner = new Scanner(System.in);
//            File file = new File(scanner.nextLine());
//            scanner = new Scanner(file);
//            long lineNumber = 1;
//            while (scanner.hasNextLine()) {
//                String word = scanner.next();
//                addToMyTreeMap(word, lineNumber);
//            }
//            scanner.close();
//        } catch (NoSuchElementException | FileNotFoundException e) {
//            e.printStackTrace();
//        }
        File file = new File(pathFile);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
            long lineNumber = 1;
            while(fileScanner.hasNextLine()){
                String readLine = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(readLine);
                while(lineScanner.hasNext()){
                    String word = lineScanner.next();
                    addToMyTreeMap(word, lineNumber);
                }
                lineScanner.close();
                lineNumber++;
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void addToMyTreeMap(String word, long lineNumber) {
        MyTreeMap myTreeMap = new MyTreeMap();
        myTreeMap.put(word, lineNumber);
        System.out.println(word);
        System.out.println(lineNumber);
    }
}
