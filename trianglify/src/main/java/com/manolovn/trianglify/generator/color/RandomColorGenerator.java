package com.manolovn.trianglify.generator.color;

import android.graphics.Color;

import java.util.Random;

/**
 * Random color generator
 */
public class RandomColorGenerator implements ColorGenerator {

    private Random rand = new Random();

    public RandomColorGenerator() {

    }

    @Override
    public int nextColor() {
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);

        return Color.rgb(r, g, b);
    }

    @Override
    public void setCount(int count) {
        // not necessary
    }
}
