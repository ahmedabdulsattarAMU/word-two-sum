package com.amu;

import java.util.*;

public class TwoSum {

    public static String getRepetition(String word) {
        if (word == null) {
            return "";
        }

        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static TwoSumsResult findTwoSum(Map<String, Set<String>> wordRepetitionMap, String targetRepetition) {
        TwoSumsResult twoSumsResult = new TwoSumsResult();

        for (String wordRepetition : wordRepetitionMap.keySet()) {
            String complementRepetition = getComplementRepetition(wordRepetition, targetRepetition);
            Set<String> complementWords = wordRepetitionMap.get(complementRepetition);
            if (complementWords != null && !complementWords.isEmpty()) {
                Set<String> words = wordRepetitionMap.get(wordRepetition);
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
}
