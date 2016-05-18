package com.manolovn.sample.point;

import com.manolovn.trianglify.generator.point.CircularPointGenerator;
import com.manolovn.trianglify.generator.point.PointGenerator;
import com.manolovn.trianglify.generator.point.RegularPointGenerator;

/**
 * Point generator factory
 *
 * @author manolovn
 */
public class PointGeneratorFactory {

    public enum Type {
        REGULAR("regular"),
        CIRCULAR("circular");

        Type(String type) {

        }
    }

    public static PointGenerator from(String stringType) {
        Type type = Type.valueOf(stringType);
        switch (type) {
            case CIRCULAR:
                return new CircularPointGenerator();
            case REGULAR:
            default:
                return new RegularPointGenerator();
        }
    }
}
