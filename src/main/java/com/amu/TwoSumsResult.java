package com.amu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TwoSumsResult {
    private final List<String> words;
    private final List<String> complementWords;

    public TwoSumsResult() {
        this.words = new ArrayList<>();
        this.complementWords = new ArrayList<>();
    }

    public TwoSumsResult(List<String> words, List<String> complementWords) {
        this.words = words;
        this.complementWords = complementWords;
    }

    public List<String> getWords() {
        return words;
    }

    public List<String> getComplementWords() {
        return complementWords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoSumsResult that = (TwoSumsResult) o;
        return (words.equals(that.words) && complementWords.equals(that.complementWords))
                || (words.equals(that.complementWords) && complementWords.equals(that.words));
    }

    @Override
    public int hashCode() {
        return Objects.hash(words, complementWords);
    }
}
