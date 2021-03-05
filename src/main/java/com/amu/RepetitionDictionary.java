package com.amu;

import com.amu.repositories.WordRepository;
import com.amu.utils.ArrayUtils;

import java.util.*;

public class RepetitionDictionary {

    private final WordRepository wordRepository;

    private final Map<String, Set<Word>> data;

    public RepetitionDictionary(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
        this.data = new HashMap<>();
    }

    public void load() {
        for (Word word : wordRepository.getAll()) {
            String repetition = word.getRepetition();
            Set<Word> associatedWords = data.get(repetition);
            if (associatedWords != null) {
                associatedWords.add(word);
            }
            else {
                data.put(repetition, ArrayUtils.asSet(word));
            }
        }
    }

    public TwoSumsResult findAllTwoSums(String targetRepetition) {
        TwoSumsResult twoSumsResult = new TwoSumsResult();

        for (String wordRepetition : data.keySet()) {
            String complementRepetition = new Word(wordRepetition)
                    .getComplementRepetition(targetRepetition);
            Set<Word> complementWords = data.get(complementRepetition);

            if (complementWords != null && !complementWords.isEmpty()) {
                Set<Word> words = data.get(wordRepetition);
                twoSumsResult = new TwoSumsResult(words, complementWords);
                break;
            }
        }

        return twoSumsResult;
    }

    public Map<String, Set<Word>> getData() {
        return data;
    }
}
