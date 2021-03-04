package com.amu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TwoSumsResult {
    private final Set<String> words;
    private final Set<String> complementWords;

    public TwoSumsResult() {
        this.words = new HashSet<>();
        this.complementWords = new HashSet<>();
    }

    public TwoSumsResult(Set<String> words, Set<String> complementWords) {
        this.words = words;
        this.complementWords = complementWords;
    }

    public Set<String> getWords() {
        return words;
    }

    public Set<String> getComplementWords() {
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
