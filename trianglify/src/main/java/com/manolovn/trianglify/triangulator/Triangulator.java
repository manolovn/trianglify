package com.manolovn.trianglify.triangulator;

import com.manolovn.trianglify.domain.Point;
import com.manolovn.trianglify.domain.Triangle;

import java.util.Vector;

/**
 * Triangulator behavior
 *
 * @author manolovn
 */
public interface Triangulator {

    Vector<Triangle> triangulate(Vector<Point> pointSet);
}
