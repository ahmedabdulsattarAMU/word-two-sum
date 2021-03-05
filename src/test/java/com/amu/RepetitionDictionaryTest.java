package com.amu;

import com.amu.repositories.WordRepository;
import com.amu.utils.ArrayUtils;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class RepetitionDictionaryTest {

    @Test
    public void wordsToRepetitionDictionary_GivenListOfWords_ReturnsRepetitionDictionary() {
        RepetitionDictionary dictionary = new RepetitionDictionary(new FakeWordRepository());

        dictionary.load();

        Map<String, Set<String>> expectedData = new HashMap<>();
        expectedData.put("adehm", Collections.singleton("ahmed"));
        expectedData.put("adeinr", Collections.singleton("adrien"));
        expectedData.put("eijlnu", Collections.singleton("julien"));
        expectedData.put("elno", ArrayUtils.asSet("elon", "leon"));
        expectedData.put("elmno", ArrayUtils.asSet("lemon", "melon"));
        expectedData.put("ceiju", Collections.singleton("juice"));
        expectedData.put("deit", ArrayUtils.asSet("tied", "diet"));
        expectedData.put("acr", Collections.singleton("car"));
        expectedData.put("aim", ArrayUtils.asSet("aim", "mia"));
        assertEquals(expectedData, dictionary.getData());
    }
}

class FakeWordRepository implements WordRepository {

    @Override
    public List<String> getAll() {
        return Arrays.asList(
                "ahmed",
                "adrien",
                "julien",
                "elon",
                "leon",
                "melon",
                "juice",
                "lemon",
                "tied",
                "car",
                "diet",
                "aim",
                "mia");
    }
}