package com.amu;

import java.util.*;

public class TwoSum {

    private String firstWord;
    private String secondWord;

    public TwoSum(String firstWord, String secondWord) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
    }

    public static String getRepetition(String word) {
        if (word == null) {
            return "";
        }

        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static TwoSumsResult findTwoSum(Map<String, List<String>> wordRepetitionMap, String targetRepetition) {
        TwoSumsResult twoSumsResult = new TwoSumsResult();

        for (String wordRepetition : wordRepetitionMap.keySet()) {
            String complementRepetition = getComplementRepetition(wordRepetition, targetRepetition);
            List<String> complementWords = wordRepetitionMap.get(complementRepetition);
            if (complementWords != null && !complementWords.isEmpty()) {
                List<String> words = wordRepetitionMap.get(wordRepetition);
                twoSumsResult = new TwoSumsResult(words, complementWords);
                break;
            }
        }

        return twoSumsResult;
    }

    public static boolean lettersBelongToRepetition(String letters, String repetition) {
        for (char letter : letters.toCharArray()) {
            if (repetition.indexOf(letter) == -1) {
                return false;
            }
        }

        return true;
    }

    public static String getComplementRepetition(String sourceRepetition, String targetRepetition) {
        if (sourceRepetition == null
                || targetRepetition == null
                || sourceRepetition.length() >= targetRepetition.length()
                || !lettersBelongToRepetition(sourceRepetition, targetRepetition)
        ) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : targetRepetition.toCharArray()) {
            if (sourceRepetition.indexOf(c) == -1) {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoSum twoSum = (TwoSum) o;
        return (firstWord.equalsIgnoreCase(twoSum.firstWord) && secondWord.equalsIgnoreCase(twoSum.secondWord))
                || (firstWord.equalsIgnoreCase(twoSum.secondWord) && secondWord.equalsIgnoreCase(twoSum.firstWord));
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstWord, secondWord);
    }
}
