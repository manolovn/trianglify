package com.manolovn.trianglify.color;

import com.manolovn.colorbrewer.ColorBrewer;

/**
 * Color brewer color generator
 *
 * @author manolovn
 */
public class BrewerColorGenerator implements ColorGenerator {

    int i = 0;
    int[] colors;

    public BrewerColorGenerator() {
        colors = ColorBrewer.YlOrBr.getColorPalette(100);
    }

    @Override
    public int nextColor() {
        int color = colors[i];
        i++;
        return color;
    }
}
