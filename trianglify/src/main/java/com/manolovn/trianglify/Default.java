package com.manolovn.trianglify;

import com.manolovn.trianglify.generator.color.ColorGenerator;
import com.manolovn.trianglify.generator.color.RandomColorGenerator;

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
}
