package com.shpp.p2p.cs.akartel.assignment5;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Assignment5Part3 read file from resources (dictionary) asks user to input some symbols
 * and checks if words in file contains that symbols relatively to their sequence
 */
public class Assignment5Part3 {
    public static void main(String[] args) {
        ArrayList<String> dictionary = readFile("src/resource/en-dictionary.txt");
        letsStart(dictionary);
    }

    /**
     * Infinity times word checks
     *
     * @param dictionary Arraylist with words for check
     */
    private static void letsStart(ArrayList<String> dictionary) {
        String inputStr = inputLetters();
        findCoincidence(dictionary, inputStr);
        letsStart(dictionary);
    }

    /** method checks every word in dictionary array for a symbols from
     * inputStr - one by one keeping sequence , case all symbols found print it
     * @param dictionary ArrayList with words
     * @param inputStr   user symbols
     */
    private static void findCoincidence(ArrayList<String> dictionary, String inputStr) {
        for (String line : dictionary) {
            int result = 0;
            int previousIndexPosition = -1;
            for (int i = 0; i < inputStr.length(); i++) {
                if (line.indexOf(inputStr.charAt(i), previousIndexPosition + 1) != -1) {
                    result++;
                    previousIndexPosition = line.indexOf(inputStr.charAt(i), previousIndexPosition + 1);
                }
            }
            if (result == inputStr.length()) System.out.println(line);
        }
    }

    /**
     * method asks user to input some symbols
     *
     * @return String of trimmed and lower-cased symbols
     */
    private static String inputLetters() {
        System.out.println("Enter a single word: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim().toLowerCase();
    }

    /**
     * method read text file from resources
     * @param filePath path to your file
     * @return ArrayList with line of read file
     */
    private static ArrayList<String> readFile(String filePath) {
        File file = new File(filePath);
        ArrayList<String> dictionary = new ArrayList<>();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                dictionary.add(scan.nextLine());
            }
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dictionary;
    }
}