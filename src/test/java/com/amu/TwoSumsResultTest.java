package com.amu;

import static org.junit.Assert.*;

import com.amu.utils.ArrayUtils;
import org.junit.Test;

public class TwoSumsResultTest {

    @Test
    public void equals_GivenEqualTwoSumsResult_ReturnsTrue() {
        assertEquals(
                new TwoSumsResult(ArrayUtils.asSet("foo", "bar"), ArrayUtils.asSet("fooBar", "BarFoo")),
                new TwoSumsResult(ArrayUtils.asSet("foo", "bar"), ArrayUtils.asSet("fooBar", "BarFoo"))
        );
    }

    @Test
    public void equals_GivenEqualTwoSumsResultInDifferentOrder_ReturnsTrue() {
        assertEquals(
                new TwoSumsResult(ArrayUtils.asSet("foo", "bar"), ArrayUtils.asSet("fooBar", "BarFoo")),
                new TwoSumsResult(ArrayUtils.asSet("fooBar", "BarFoo"), ArrayUtils.asSet("foo", "bar"))
        );
    }

    @Test
    public void equals_GivenDifferentTwoSumsResult_ReturnsFalse() {
        assertNotEquals(
                new TwoSumsResult(ArrayUtils.asSet("foo", "bar"), ArrayUtils.asSet("fooBar", "BarFoo")),
                new TwoSumsResult(ArrayUtils.asSet("zaa", "Bzr"), ArrayUtils.asSet("fooBar", "BarFoo"))
        );
    }
}
