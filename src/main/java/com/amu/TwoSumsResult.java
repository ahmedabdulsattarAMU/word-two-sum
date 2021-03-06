package com.amu;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TwoSumsResult {
    private final Set<Word> words;
    private final Set<Word> complementWords;

    public TwoSumsResult() {
        this.words = new HashSet<>();
        this.complementWords = new HashSet<>();
    }

    public TwoSumsResult(Set<Word> words, Set<Word> complementWords) {
        this.words = words;
        this.complementWords = complementWords;
    }

    public Set<Word> getWords() {
        return words;
    }

    public Set<Word> getComplementWords() {
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
        return Objects.hash(words, complementWords)
                + Objects.hash(complementWords, words);
    }
}
