package com.amu.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayUtils {

    public static <T> Set<T> asSet(T... a) {
        return new HashSet<>(Arrays.asList(a));
    }
}
