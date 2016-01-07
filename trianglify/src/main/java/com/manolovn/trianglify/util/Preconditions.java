package com.manolovn.trianglify.util;

import android.support.annotation.Nullable;

/**
 * Preconditions (extracted from guava)
 *
 * @author manolovn
 */
public class Preconditions {

    private Preconditions() {

    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    public static void checkArgument(boolean expression, @Nullable Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }
}
