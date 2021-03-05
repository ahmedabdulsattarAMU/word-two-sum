package com.amu;

import static org.junit.Assert.*;

import com.amu.utils.ArrayUtils;
import org.junit.Test;

public class TwoSumsResultTest {

    @Test
    public void equals_GivenEqualTwoSumsResult_ReturnsTrue() {
        TwoSumsResult firstResult = new TwoSumsResult(
                ArrayUtils.asSet(new Word("foo"), new Word("bar")),
                ArrayUtils.asSet(new Word("fooBar"), new Word("BarFoo"))
        );
        TwoSumsResult secondResult = new TwoSumsResult(
                ArrayUtils.asSet(new Word("foo"), new Word("bar")),
                ArrayUtils.asSet(new Word("fooBar"), new Word("BarFoo"))
        );

        assertEquals(firstResult, secondResult);
    }

    @Test
    public void equals_GivenEqualTwoSumsResultInDifferentOrder_ReturnsTrue() {
        TwoSumsResult firstResult = new TwoSumsResult(
                ArrayUtils.asSet(new Word("foo"), new Word("bar")),
                ArrayUtils.asSet(new Word("fooBar"), new Word("BarFoo"))
        );
        TwoSumsResult secondResult = new TwoSumsResult(
                ArrayUtils.asSet(new Word("fooBar"), new Word("BarFoo")),
                ArrayUtils.asSet(new Word("foo"), new Word("bar"))
        );

        assertEquals(firstResult, secondResult);
    }

    @Test
    public void equals_GivenDifferentTwoSumsResult_ReturnsFalse() {
        TwoSumsResult firstResult = new TwoSumsResult(
                ArrayUtils.asSet(new Word("foo"), new Word("bar")),
                ArrayUtils.asSet(new Word("fooBar"), new Word("BarFoo"))
        );
        TwoSumsResult secondResult = new TwoSumsResult(
                ArrayUtils.asSet(new Word("zaa"), new Word("Bzr")),
                ArrayUtils.asSet(new Word("fooBar"), new Word("BarFoo"))
        );

        assertNotEquals(firstResult, secondResult);
    }
}
