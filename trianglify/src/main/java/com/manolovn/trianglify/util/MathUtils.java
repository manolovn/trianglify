package com.manolovn.trianglify.util;

/**
 * Math utils
 *
 * @author manolovn
 */
public class MathUtils {

    public static boolean hasSameSign(double a, double b) {
        return Math.signum(a) == Math.signum(b);
    }
}
