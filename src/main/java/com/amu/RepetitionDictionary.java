package com.amu;

import com.amu.repositories.WordRepository;
import com.amu.utils.ArrayUtils;

import java.util.*;

public class RepetitionDictionary {

    private WordRepository wordRepository;

    private final Map<String, Set<String>> data;

    public RepetitionDictionary(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
        this.data = new HashMap<>();
    }

    public void load() {
        for (String word : wordRepository.getAll()) {
            String repetition = TwoSum.getRepetition(word);
            Set<String> associatedWords = data.get(repetition);
            if (associatedWords != null) {
                associatedWords.add(word);
            }
            else {
                data.put(repetition, ArrayUtils.asSet(word));
            }
        }
    }

    public Map<String, Set<String>> getData() {
        return data;
    }
}
