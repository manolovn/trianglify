package com.manolovn.trianglify.domain;

/**
 * Edge entity
 *
 * @author manolovn
 */
public class Edge {

    public Point a;
    public Point b;

    public Edge(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

}
