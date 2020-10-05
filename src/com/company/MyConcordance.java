package com.company;

import java.nio.file.Files;
import java.util.Scanner;

public class MyConcordance {

    public static void main(String[] args) {

        String nameFile = readNameFileFromUser();

        readFile(nameFile);
    }

    private static String readNameFileFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name file and extension: (example - NAMEFILE.txt)");
        String nameFile = scanner.nextLine();
        scanner.close();
        return nameFile;
    }

    private static void readFile(String nameFile) {
        Scanner scanner = new Scanner(nameFile);
        long lineNumber = 1;
        while (scanner.hasNext()){
            if(scanner.next().compareTo("\n") == 0)
                lineNumber++;
            String word = scanner.next();
            addToMyTreeMap(word, lineNumber);
        }
    }

    private static void addToMyTreeMap(String word, long lineNumber) {
        MyTreeMap myTreeMap = new MyTreeMap();
        myTreeMap.put(word, lineNumber);
    }
}
