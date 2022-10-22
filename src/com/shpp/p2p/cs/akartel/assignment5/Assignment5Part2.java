package com.shpp.p2p.cs.akartel.assignment5;

import com.shpp.cs.a.console.TextProgram;

/**
 * Assignment5Part2 addNumericStrings that user input
 * and shows results
 */
public class Assignment5Part2 extends TextProgram {
    public void run() {
        /* Sit in a loop, reading numbers and adding them. */
        while (true) {
            String n1 = readLine("Enter first number: ");
            String n2 = readLine("Enter second number: ");
            println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
            println();
        }
    }

    /**
     * Given two string representations of nonnegative integers, adds the
     * numbers represented by those strings and returns the result.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return A String representation of n1 + n2
     */
    private String addNumericStrings(String n1, String n2) {
        if (n1.length() > n2.length()) n2 = stringExtension(n1, n2) + n2;
        if (n1.length() < n2.length()) n1 = stringExtension(n1, n2) + n1;

        char[] chAr1 = n1.toCharArray();
        char[] chAr2 = n2.toCharArray();

        return plus(chAr1, chAr2).toString();
    }

    /**
     * method build string by adding 0 for each time strings have deficiency in their length
     * @param n1 string
     * @param n2 string
     * @return string like "000" quantity of '0' relatively to deficiency between n1,n2 length
     */
    private String stringExtension(String n1, String n2) {
        StringBuilder result = new StringBuilder();
        int deficiency = Math.abs(n1.length() - n2.length());
        result.append("0".repeat(deficiency));
        return result.toString();
    }

    /**
     * Method add charArray1 last char to charArray2 last char inverted into (int)
     * case value >10 method add 1 to next index
     * (case next index not exist method just add 1 before string)
     * @param chAr1 char[]
     * @param chAr2 char[]
     * @return result string reversed (to show correct value)
     */
    private StringBuffer plus(char[] chAr1, char[] chAr2) {
        StringBuffer resultStr = new StringBuffer();
        int currentNum;
        boolean lastOneAdd = false;

        for (int i = 1; i <= chAr1.length; i++) {
            currentNum = (chAr1[chAr1.length - i] - '0') + (chAr2[chAr2.length - i] - '0');
            if (currentNum >= 10) {
                currentNum = currentNum % 10;
                if (chAr1.length - i - 1 >= 0) chAr1[chAr1.length - i - 1] += 1;
                else lastOneAdd = true;
            }
            resultStr.append(currentNum);
        }
        return lastOneAdd ? resultStr.append(1).reverse() : resultStr.reverse();

    }
}