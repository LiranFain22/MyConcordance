package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyConcordance {

    private static FileWriter writer;

    static {
        try {
            writer = new FileWriter(new File("C:\\Users\\Liran\\Desktop\\result.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        System.out.print("Enter the FULL PATH file with extension : ");
        Scanner scanner = new Scanner(System.in);
        String pathFile = scanner.nextLine();
        MyTreeMap myTreeMap = readFile(pathFile);
        saveToFile(myTreeMap);
        writer.close();
    }

    private static void saveToFile(MyTreeMap myTreeMap) {
        if(myTreeMap.getRoot() != null){
            saveToFile(new MyTreeMap(myTreeMap.getRoot().getLeft()));
            try {
                if(myTreeMap.getRoot() != null){
                    writer.write(myTreeMap.getRoot().toString() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            saveToFile(new MyTreeMap(myTreeMap.getRoot().getRight()));
        }
    }

    public static MyTreeMap readFile(String pathFile) {
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
        MyTreeMap myTreeMap = new MyTreeMap();
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
                    String newWord = word.replaceAll("[-+.^:,]","");
                    myTreeMap.put(newWord, lineNumber);
                }
                lineScanner.close();
                lineNumber++;
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  myTreeMap;
    }
}
