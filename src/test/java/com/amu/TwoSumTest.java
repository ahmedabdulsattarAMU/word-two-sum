package com.amu;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class TwoSumTest {

    @Test
    public void getRepetition_GivenWord_ReturnsItsRepetition() {
        String word = "Ami";
        assertEquals("aim", TwoSum.getRepetition(word));
    }

    @Test
    public void equals_GivenEqualTwoSum_ReturnsTrue() {
        assertEquals(new TwoSum("Yezan", "Rafed"), new TwoSum("Rafed", "Yezan"));
    }

    @Test
    public void equals_GivenDifferentTwoSum_ReturnsFalse() {
        assertNotEquals(new TwoSum("Yezan", "Ahmed"), new TwoSum("Rafed", "Yezan"));
    }

    @Test
    public void lettersBelongToRepetition_GivenLettersContainedInRepetition_ReturnsTrue() {
        assertTrue(TwoSum.lettersBelongToRepetition("ador", "abcdgmnopqr"));
    }

    @Test
    public void lettersBelongToRepetition_GivenSomeLettersNotContainedInRepetition_ReturnsFalse() {
        assertFalse(TwoSum.lettersBelongToRepetition("adzr", "abcdgmnopqr"));
    }

    @Test
    public void getComplementRepetition_GivenSourceRepetitionContainedInTarget_ReturnsComplementRepetition() {
        String complementRepetition = TwoSum.getComplementRepetition("en", "acemn");
        assertEquals("acm", complementRepetition);
    }

    @Test
    public void getComplementRepetition_GivenSourceRepetitionNotContainedInTarget_ReturnsEmptyRepetition() {
        String complementRepetition = TwoSum.getComplementRepetition("ez", "acemn");
        assertTrue(complementRepetition.isEmpty());
    }

    @Test
    public void findTwoSum_GivenMapOfWordAndTargetRepetition_FindsTwoSumWords() {
        // arrange
        Map<String, List<String>> wordRepetitionMap = new HashMap<>();
        wordRepetitionMap.put(TwoSum.getRepetition("ami"), Collections.singletonList("ami"));
        wordRepetitionMap.put(TwoSum.getRepetition("diet"), Arrays.asList("diet", "tied"));
        wordRepetitionMap.put(TwoSum.getRepetition("ne"), Arrays.asList("ne", "en"));
        wordRepetitionMap.put(TwoSum.getRepetition("amine"), Collections.singletonList("amine"));

        // act
        TwoSumsResult twoSumsResult = TwoSum.findTwoSum(wordRepetitionMap, "aeimn");

        // assert
        List<String> words = Collections.singletonList("ami");
        List<String> complementWords = Arrays.asList("ne", "en");
        assertEquals(new TwoSumsResult(words, complementWords), twoSumsResult);
    }
}
