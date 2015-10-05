package com.manolovn.trianglify.triangulator;

import com.manolovn.trianglify.point.Point;
import com.manolovn.trianglify.triangle.Edge;
import com.manolovn.trianglify.triangle.Triangle;

import java.util.Vector;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Delaunay triangulator
 */
public class DelaunayTriangulator implements Triangulator {

    private Vector<Point> pointSet;
    private Triangulation triangulation;

    public DelaunayTriangulator(Vector<Point> pointSet) {
        checkNotNull(pointSet);
        checkArgument(pointSet.size() >= 3, "Can't triangulate less than three points");
        this.pointSet = pointSet;
        this.triangulation = new Triangulation();
    }

    @Override
    public Vector<Triangle> triangulate() {
        triangulation = new Triangulation();

        /**
         * In order for the in circumcircle test to not consider the vertices of
         * the super triangle we have to start out with a big triangle
         * containing the whole point set. We have to scale the super triangle
         * to be very large. Otherwise the triangulation is not convex.
         */
        int maxOfAnyCoordinate = 0;

        for (Point point : pointSet) {
            maxOfAnyCoordinate = Math.max(Math.max(point.x, point.y), maxOfAnyCoordinate);
        }

        maxOfAnyCoordinate *= 16;

        Point p1 = new Point(0, 3 * maxOfAnyCoordinate);
        Point p2 = new Point(3 * maxOfAnyCoordinate, 0);
        Point p3 = new Point(-3 * maxOfAnyCoordinate, -3 * maxOfAnyCoordinate);

        Triangle superTriangle = new Triangle(p1, p2, p3);

        triangulation.add(superTriangle);

        for (int i = 0; i < pointSet.size(); i++) {
            Triangle triangle = triangulation.findContainingTriangle(pointSet.get(i));

            if (triangle == null) {
                Edge edge = triangulation.findNearestEdge(pointSet.get(i));

                Triangle first = triangulation.findOneTriangleSharing(edge);
                Triangle second = triangulation.findNeighbour(first, edge);

                Point firstNoneEdgeVertex = first.getNoneEdgeVertex(edge);
                Point secondNoneEdgeVertex = second.getNoneEdgeVertex(edge);

                triangulation.remove(first);
                triangulation.remove(second);

                Triangle triangle1 = new Triangle(edge.a, firstNoneEdgeVertex, pointSet.get(i));
                Triangle triangle2 = new Triangle(edge.b, firstNoneEdgeVertex, pointSet.get(i));
                Triangle triangle3 = new Triangle(edge.a, secondNoneEdgeVertex, pointSet.get(i));
                Triangle triangle4 = new Triangle(edge.b, secondNoneEdgeVertex, pointSet.get(i));

                triangulation.add(triangle1);
                triangulation.add(triangle2);
                triangulation.add(triangle3);
                triangulation.add(triangle4);

                legalizeEdge(triangle1, new Edge(edge.a, firstNoneEdgeVertex), pointSet.get(i));
                legalizeEdge(triangle2, new Edge(edge.b, firstNoneEdgeVertex), pointSet.get(i));
                legalizeEdge(triangle3, new Edge(edge.a, secondNoneEdgeVertex), pointSet.get(i));
                legalizeEdge(triangle4, new Edge(edge.b, secondNoneEdgeVertex), pointSet.get(i));
            } else {
                Point a = triangle.a;
                Point b = triangle.b;
                Point c = triangle.c;

                triangulation.remove(triangle);

                Triangle first = new Triangle(a, b, pointSet.get(i));
                Triangle second = new Triangle(b, c, pointSet.get(i));
                Triangle third = new Triangle(c, a, pointSet.get(i));

                triangulation.add(first);
                triangulation.add(second);
                triangulation.add(third);

                legalizeEdge(first, new Edge(a, b), pointSet.get(i));
                legalizeEdge(second, new Edge(b, c), pointSet.get(i));
                legalizeEdge(third, new Edge(c, a), pointSet.get(i));
            }
        }

        triangulation.removeTrianglesUsing(superTriangle.a);
        triangulation.removeTrianglesUsing(superTriangle.b);
        triangulation.removeTrianglesUsing(superTriangle.c);

        return triangulation.getTriangles();
    }

    private void legalizeEdge(Triangle triangle, Edge edge, Point vertex) {
        Triangle neighbourTriangle = triangulation.findNeighbour(triangle, edge);

        if (neighbourTriangle != null) {
            if (neighbourTriangle.isPointInCircumcircle(vertex)) {
                triangulation.remove(triangle);
                triangulation.remove(neighbourTriangle);

                Point noneEdgeVertex = neighbourTriangle.getNoneEdgeVertex(edge);

                Triangle firstTriangle = new Triangle(noneEdgeVertex, edge.a, vertex);
                Triangle secondTriangle = new Triangle(noneEdgeVertex, edge.b, vertex);

                triangulation.add(firstTriangle);
                triangulation.add(secondTriangle);

                legalizeEdge(firstTriangle, new Edge(noneEdgeVertex, edge.a), vertex);
                legalizeEdge(secondTriangle, new Edge(noneEdgeVertex, edge.b), vertex);
            }
        }
    }
}
