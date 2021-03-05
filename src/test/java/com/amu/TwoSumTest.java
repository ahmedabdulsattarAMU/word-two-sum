package com.amu;

import static org.junit.Assert.*;

import com.amu.utils.ArrayUtils;
import org.junit.Test;

import java.util.*;

public class TwoSumTest {

    @Test
    public void getRepetition_GivenWord_ReturnsItsRepetition() {
        String word = "Ami";
        assertEquals("aim", TwoSum.getRepetition(word));
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
        Map<String, Set<String>> wordRepetitionMap = new HashMap<>();
        wordRepetitionMap.put(TwoSum.getRepetition("ami"), Collections.singleton("ami"));
        wordRepetitionMap.put(TwoSum.getRepetition("diet"), ArrayUtils.asSet("diet", "tied"));
        wordRepetitionMap.put(TwoSum.getRepetition("ne"), ArrayUtils.asSet("ne", "en"));
        wordRepetitionMap.put(TwoSum.getRepetition("amine"), Collections.singleton("amine"));

        // act
        TwoSumsResult twoSumsResult = TwoSum.findTwoSum(wordRepetitionMap, "aeimn");

        // assert
        Set<String> words = Collections.singleton("ami");
        Set<String> complementWords = ArrayUtils.asSet("ne", "en");
        assertEquals(new TwoSumsResult(words, complementWords), twoSumsResult);
    }
}
