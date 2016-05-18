package com.manolovn.trianglify;

import com.manolovn.trianglify.generator.color.ColorGenerator;
import com.manolovn.trianglify.generator.color.RandomColorGenerator;
import com.manolovn.trianglify.generator.point.PointGenerator;
import com.manolovn.trianglify.generator.point.RegularPointGenerator;

/**
 * Container for default values
 *
 * @author manolovn
 */
class Default {

    static int cellSize = 200;
    static int variance = 50;
    static int bleedX = cellSize;
    static int bleedY = cellSize;
    static ColorGenerator colorGenerator = new RandomColorGenerator();
    static PointGenerator pointGenerator = new RegularPointGenerator();
}
