package com.shpp.p2p.cs.akartel.assignment5;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Assignment5Part4 - read csv encrypted file and
 * extract part of string - line divided by commas
 * only in case this come not commented by special symbol - "
 * and after removing special symbols for encrypting csv files ["] [,]
 * prints results
 */
public class Assignment5Part4 {
    public static void main(String[] args) {
        System.out.println(extractColumn("src/resource/1234", 6));
    }

    /**
     * Method read file and
     * extract part of string - line
     * divided by commas
     * only in case this come not commented by special symbol - "
     * after that treats with extracted line by removing
     * special symbols - " that was used for encrypting symbols :  [,] and ["]
     * and add them to ArrayList<String>
     *
     * @param filename    out file
     * @param columnIndex column number
     * @return - Array list with columns / case no file found - null
     */
    private static ArrayList<String> extractColumn(String filename, int columnIndex) {
        File file = new File(filename);
        ArrayList<String> result = new ArrayList<>();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();

                String linePart = substringLine(line, columnIndex);

                if (linePart.contains(",")) linePart = linePart.substring(1, linePart.length() - 1);

                result.add(linePart.replaceAll("\"\"", "\""));
            }
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    /**
     * this method extract part of string - line
     * divided by commas
     * only in case this comma not commented by special symbol ["]
     * @param line        - string to handle
     * @param columnIndex shows what part of column to extract
     * @return part of string
     */
    private static String substringLine(String line, int columnIndex) {
        boolean trueComma = true;
        int commaCounter = 0;
        int startPosition = 0;
        int endPosition = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '"') trueComma = !trueComma;
// using startPosition + 1 to have index of string after comma
            if (commaCounter == columnIndex - 1) startPosition = i + 1;

            if (trueComma && line.charAt(i) == ',') commaCounter++;
// using endPosition + 1 to have index of string exactly on next comma or in the end of string
            if (commaCounter == columnIndex) endPosition = i + 1;
        }
        return line.substring(startPosition, endPosition);
    }
}
