package com.manolovn.trianglify.domain;

/**
 * Point entity
 *
 * @author manolovn
 */
public class Point {

    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point sub(Point point) {
        return new Point(this.x - point.x, this.y - point.y);
    }

    public Point add(Point point) {
        return new Point(this.x + point.x, this.y + point.y);
    }

    public Point mult(int scalar) {
        return new Point(this.x * scalar, this.y * scalar);
    }

    public double mag() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double dot(Point point) {
        return this.x * point.x + this.y * point.y;
    }

    public double cross(Point point) {
        return this.y * point.x - this.x * point.y;
    }
}
