package com.manolovn.trianglify.triangle;

import com.manolovn.trianglify.point.Point;

/**
 * Edge entity
 */
public class Edge {

    public Point a;
    public Point b;

    public Edge(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

}
