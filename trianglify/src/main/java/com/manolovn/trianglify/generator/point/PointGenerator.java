package com.manolovn.trianglify.generator.point;

import com.manolovn.trianglify.domain.Point;

import java.util.Vector;

/**
 * Point generator
 */
public interface PointGenerator {

    Vector<Point> generatePoints(int width, int height);

    void setBleedX(int bleedX);

    void setBleedY(int bleedY);
}
