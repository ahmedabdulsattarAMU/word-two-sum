package com.amu;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class TwoSumsResultTest {

    @Test
    public void equals_GivenEqualTwoSumsResult_ReturnsTrue() {
        assertEquals(
                new TwoSumsResult(Arrays.asList("foo", "bar"), Arrays.asList("fooBar", "BarFoo")),
                new TwoSumsResult(Arrays.asList("foo", "bar"), Arrays.asList("fooBar", "BarFoo"))
        );
    }

    @Test
    public void equals_GivenEqualTwoSumsResultInDifferentOrder_ReturnsTrue() {
        assertEquals(
                new TwoSumsResult(Arrays.asList("foo", "bar"), Arrays.asList("fooBar", "BarFoo")),
                new TwoSumsResult(Arrays.asList("fooBar", "BarFoo"), Arrays.asList("foo", "bar"))
        );
    }

    @Test
    public void equals_GivenDifferentTwoSumsResult_ReturnsFalse() {
        assertNotEquals(
                new TwoSumsResult(Arrays.asList("foo", "bar"), Arrays.asList("fooBar", "BarFoo")),
                new TwoSumsResult(Arrays.asList("zaa", "Bzr"), Arrays.asList("fooBar", "BarFoo"))
        );
    }
}
