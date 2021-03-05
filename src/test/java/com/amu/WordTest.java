package com.amu;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {

    @Test
    public void equals_GivenEqualTwoWords_ReturnsTrue() {
        assertEquals(
                new Word("Elon"),
                new Word("elon")
        );
    }

    @Test
    public void equals_GivenDifferentWords_ReturnsFalse() {
        assertNotEquals(
                new Word("Elon"),
                new Word("Mask")
        );
    }

    @Test
    public void getRepetition_GivenWord_ReturnsItsRepetition() {
        Word word = new Word("Ami");
        assertEquals("aim", word.getRepetition());
    }

    @Test
    public void getComplementRepetition_GivenWordContainedInRepetition_ReturnsComplementRepetition() {
        Word word = new Word("en");
        String complementRepetition = word.getComplementRepetition("acemn");
        assertEquals("acm", complementRepetition);
    }

    @Test
    public void getComplementRepetition_GivenWordNotContainedInRepetition_ReturnsEmptyRepetition() {
        Word word = new Word("ez");
        String complementRepetition = word.getComplementRepetition("acemn");
        assertTrue(complementRepetition.isEmpty());
    }

    @Test
    public void getComplementRepetition_GivenRepetitionWithDuplicateLetters_ReturnsComplementRepetition() {
        Word word = new Word("elno");
        String complementRepetition = word.getComplementRepetition("deeilnot");
        assertEquals("deit", complementRepetition);
    }

    @Test
    public void belongsToRepetition_GivenLettersContainedInRepetition_ReturnsTrue() {
        Word word = new Word("ador");
        assertTrue(word.belongsToRepetition("abcdgmnopqr"));
    }

    @Test
    public void belongsToRepetition_GivenSomeLettersNotContainedInRepetition_ReturnsFalse() {
        Word word = new Word("adzr");
        assertFalse(word.belongsToRepetition("abcdgmnopqr"));
    }
}
