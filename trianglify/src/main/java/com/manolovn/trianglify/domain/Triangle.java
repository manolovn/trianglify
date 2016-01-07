package com.manolovn.trianglify.domain;

import com.manolovn.trianglify.util.EdgeDistanceComparator;
import com.manolovn.trianglify.util.MathUtils;

import java.util.Arrays;

/**
 * Triangle entity
 *
 * @author manolovn
 */
public class Triangle {

    public Point a;
    public Point b;
    public Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean contains(Point point) {
        double pab = point.sub(a).cross(b.sub(a));
        double pbc = point.sub(b).cross(c.sub(b));

        if (!MathUtils.hasSameSign(pab, pbc)) {
            return false;
        }

        double pca = point.sub(c).cross(a.sub(c));

        return MathUtils.hasSameSign(pab, pca);
    }

    public boolean isPointInCircumcircle(Point point) {
        double a11 = a.x - point.x;
        double a21 = b.x - point.x;
        double a31 = c.x - point.x;

        double a12 = a.y - point.y;
        double a22 = b.y - point.y;
        double a32 = c.y - point.y;

        double a13 = (a.x - point.x) * (a.x - point.x) + (a.y - point.y) * (a.y - point.y);
        double a23 = (b.x - point.x) * (b.x - point.x) + (b.y - point.y) * (b.y - point.y);
        double a33 = (c.x - point.x) * (c.x - point.x) + (c.y - point.y) * (c.y - point.y);

        double det = a11 * a22 * a33 + a12 * a23 * a31 + a13 * a21 * a32 - a13 * a22 * a31
                - a12 * a21 * a33 - a11 * a23 * a32;

        if (isOrientedCCW()) {
            return det > 0.0d;
        }

        return det < 0.0d;
    }

    public boolean isOrientedCCW() {
        double a11 = a.x - c.x;
        double a21 = b.x - c.x;

        double a12 = a.y - c.y;
        double a22 = b.y - c.y;

        double det = a11 * a22 - a12 * a21;

        return det > 0.0d;
    }

    public boolean isNeighbour(Edge edge) {
        return (a == edge.a || b == edge.a || c == edge.a)
                && (a == edge.b || b == edge.b || c == edge.b);
    }

    public Point getNoneEdgeVertex(Edge edge) {
        if (a != edge.a && a != edge.b) {
            return a;
        } else if (b != edge.a && b != edge.b) {
            return b;
        } else if (c != edge.a && c != edge.b) {
            return c;
        }
        return null;
    }

    public boolean hasVertex(Point point) {
        return a == point || b == point || c == point;
    }

    public EdgeDistanceComparator findNearestEdge(Point point) {
        EdgeDistanceComparator[] edges = new EdgeDistanceComparator[3];

        edges[0] = new EdgeDistanceComparator(
                new Edge(a, b), computeClosestPoint(new Edge(a, b), point).sub(point).mag());
        edges[1] = new EdgeDistanceComparator(
                new Edge(b, c), computeClosestPoint(new Edge(b, c), point).sub(point).mag());
        edges[2] = new EdgeDistanceComparator(
                new Edge(c, a), computeClosestPoint(new Edge(c, a), point).sub(point).mag());

        Arrays.sort(edges);
        return edges[0];
    }

    private Point computeClosestPoint(Edge edge, Point point) {
        Point ab = edge.b.sub(edge.a);
        double t = point.sub(edge.a).dot(ab) / ab.dot(ab);

        if (t < 0.0d) {
            t = 0.0d;
        } else if (t > 1.0d) {
            t = 1.0d;
        }

        return edge.a.add(ab.mult((int) t));
    }
}
