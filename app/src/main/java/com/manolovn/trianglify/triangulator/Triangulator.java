package com.manolovn.trianglify.triangulator;

import com.manolovn.trianglify.triangle.Triangle;

import java.util.Vector;

/**
 * Triangulator behavior
 */
public interface Triangulator {

    Vector<Triangle> triangulate();
}
