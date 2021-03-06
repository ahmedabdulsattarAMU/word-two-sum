package com.amu;

import com.amu.repositories.WordRepository;
import com.amu.utils.ArrayUtils;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class RepetitionDictionaryTest {

    @Test
    public void load_GivenListOfWords_ReturnsRepetitionDictionary() {
        RepetitionDictionary dictionary = new RepetitionDictionary(new FakeWordRepository());

        dictionary.load();

        Map<String, Set<Word>> expectedData = new HashMap<>();
        expectedData.put("adehm", Collections.singleton(new Word("ahmed")));
        expectedData.put("adeinr", Collections.singleton(new Word("adrien")));
        expectedData.put("eijlnu", Collections.singleton(new Word("julien")));
        expectedData.put("elno", ArrayUtils.asSet(new Word("elon"), new Word("leon")));
        expectedData.put("elmno", ArrayUtils.asSet(new Word("lemon"), new Word("melon")));
        expectedData.put("ceiju", Collections.singleton(new Word("juice")));
        expectedData.put("deit", ArrayUtils.asSet(new Word("tied"), new Word("diet")));
        expectedData.put("acr", Collections.singleton(new Word("car")));
        expectedData.put("aim", ArrayUtils.asSet(new Word("aim"), new Word("mia")));
        assertEquals(expectedData, dictionary.getData());
    }

    @Test
    public void findTwoSum_GivenDictionaryAndTargetRepetitionWithDuplicateLetters_FindsTwoSumWords() {
        // arrange
        RepetitionDictionary dictionary = new RepetitionDictionary(new FakeWordRepository());

        dictionary.load();

        // act
        Set<TwoSumsResult> twoSumsResults = dictionary.findAllTwoSums("deeilnot");

        // assert
        Set<TwoSumsResult> expectedResults = Collections.singleton(
                new TwoSumsResult(
                        ArrayUtils.asSet(new Word("elon"), new Word("leon")),
                        ArrayUtils.asSet(new Word("tied"), new Word("diet")))
        );

        assertEquals(expectedResults, twoSumsResults);
    }

    @Test
    public void findTwoSum_GivenDictionaryAndTargetRepetition_FindsTwoSumWords() {
        // arrange
        WordRepository fakeRepository = new WordRepository() {
            @Override
            public List<Word> getAll() {
                return Arrays.asList(
                        new Word("ami"),
                        new Word("diet"),
                        new Word("tied"),
                        new Word("ne"),
                        new Word("en"),
                        new Word("amine"),
                        new Word("ai"),
                        new Word("men")
                );
            }
        };

        RepetitionDictionary dictionary = new RepetitionDictionary(fakeRepository);
        dictionary.load();

        // act
        Set<TwoSumsResult> twoSumsResults = dictionary.findAllTwoSums("aeimn");

        // assert
        Set<TwoSumsResult> expectedResults = ArrayUtils.asSet(
            new TwoSumsResult(
                  Collections.singleton(new Word("ami")),
                  ArrayUtils.asSet(new Word("ne"), new Word("en"))),
            new TwoSumsResult(
                    Collections.singleton(new Word("ai")),
                    Collections.singleton(new Word("men"))
            )
        );

        assertEquals(expectedResults, twoSumsResults);
    }
}

class FakeWordRepository implements WordRepository {

    @Override
    public List<Word> getAll() {
        return Arrays.asList(
                new Word("ahmed"),
                new Word("adrien"),
                new Word("julien"),
                new Word("elon"),
                new Word("leon"),
                new Word("melon"),
                new Word("juice"),
                new Word("lemon"),
                new Word("tied"),
                new Word("car"),
                new Word("diet"),
                new Word("aim"),
                new Word("mia")
        );
    }
}