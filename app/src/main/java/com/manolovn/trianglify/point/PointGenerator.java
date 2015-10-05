package com.manolovn.trianglify.point;

import java.util.Vector;

/**
 * Point generator
 */
public interface PointGenerator {

    Vector<Point> generatePoints(int width, int height);

    void setBleedX(int bleedX);

    void setBleedY(int bleedY);
}
