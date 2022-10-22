package com.shpp.p2p.cs.akartel.assignment5;

import com.shpp.cs.a.console.TextProgram;

/**
 * Assignment5Part1 asks user to input word and shows syllable quantities
 */
public class Assignment5Part1 extends TextProgram {
    public void run() {


        /* Repeatedly prompt the user for a word and print out the estimated
         * number of syllables in that word.
         */
        while (true) {
            String word = readLine("Enter a single word: ");
            println("  Syllable count: " + syllablesIn(word));
        }
    }

    /**
     * Given a word, estimates the number of syllables in that word according to the
     * heuristic specified in the handout.
     *
     * @param word A string containing a single word.
     * @return An estimate of the number of syllables in that word.
     */
    private int syllablesIn(String word) {
        int syllableCounter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word, i)) syllableCounter++;
            /*this if checks if we have next vowel after vowel
            in this case count it as one syllable */
            if (i != 0 && isVowel(word, i - 1) && isVowel(word, i)) syllableCounter--;
        }
        /* this if checks some exceptions in words - if last symbol is 'e'
         usually it will not provide syllable and this if removes 1 syllable
           except :  - double letters 'ee' in the end
                     - 'le' in the end of word after consonant letter   */
        if (word.length() >= 3 && word.toLowerCase().charAt(word.length() - 1) == 'e') {
            syllableCounter--;
            if (word.toLowerCase().charAt(word.length() - 2) == 'e') syllableCounter++;
            if (word.toLowerCase().charAt(word.length() - 2) == 'l' && !isVowel(word, word.length() - 3))
                syllableCounter++;
        }
        /* take care for some exceptions if program
        calculations showing 0 syllable like (me the she be..)
        method return at least 1 syllable */
        return syllableCounter != 0 ? syllableCounter : 1;
    }

    /**
     * check current symbol Vowel or Consonant
     *
     * @param word - word entered by user
     * @param i    - current char of word
     * @return vowel or consonant (true false)
     */
    private boolean isVowel(String word, int i) {
        switch (word.toLowerCase().charAt(i)) {
            case 'a', 'e', 'i', 'o', 'u', 'y' -> {
                return true;
            }
        }
        return false;
    }
}