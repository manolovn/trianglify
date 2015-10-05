package com.manolovn.trianglify.point;

import java.util.Random;
import java.util.Vector;

/**
 * Regular point generator
 */
public class RegularPointGenerator implements PointGenerator {

    private final Random random = new Random();
    private final int cellSize;
    private final int variance;

    private int bleedX = 0;
    private int bleedY = 0;

    public RegularPointGenerator(int cellSize, int variance) {
        this.cellSize = cellSize;
        this.variance = variance;
    }

    @Override
    public void setBleedX(int bleedX) {
        this.bleedX = bleedX;
    }

    @Override
    public void setBleedY(int bleedY) {
        this.bleedY = bleedY;
    }

    @Override
    public Vector<Point> generatePoints(int width, int height) {
        Vector<Point> points = new Vector<>();

        for (int i = -bleedX; i < width + bleedX; i += cellSize) {
            for (int j = -bleedY; j < height + bleedY; j += cellSize) {
                int x = i + cellSize / 2 + random.nextInt(variance);
                int y = j + cellSize / 2 + random.nextInt(variance);
                points.add(new Point(x, y));
            }
        }

        return points;
    }
}
