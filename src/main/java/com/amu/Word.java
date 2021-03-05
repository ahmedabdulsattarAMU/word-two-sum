package com.amu;

import java.util.Arrays;
import java.util.Objects;

public class Word {

    private final String content;

    public Word(String content) {
        if (content == null) {
            throw new IllegalArgumentException("Content should not be null");
        }

        this.content = content;
    }

    public String getRepetition() {
        char[] chars = content.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public String getComplementRepetition(String repetition) {
        if (repetition == null
                || content.length() >= repetition.length()
                || !belongsToRepetition(repetition)
        ) {
            return "";
        }

        StringBuilder counterStringBuilder = new StringBuilder(content);

        StringBuilder complementStringBuilder = new StringBuilder();
        for (char c : repetition.toCharArray()) {
            int idx = counterStringBuilder.indexOf(String.valueOf(c));
            if (idx == -1) {
                complementStringBuilder.append(c);
            }
            else {
                counterStringBuilder.deleteCharAt(idx);
            }
        }

        return complementStringBuilder.toString();
    }

    public boolean belongsToRepetition(String repetition) {
        for (char letter : content.toCharArray()) {
            if (repetition.indexOf(letter) == -1) {
                return false;
            }
        }

        return true;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return content.equalsIgnoreCase(word.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return content;
    }
}
