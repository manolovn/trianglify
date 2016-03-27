package com.manolovn.trianglify.util;

import android.support.annotation.NonNull;

import com.manolovn.trianglify.domain.Edge;

/**
 * Edge distance comparator
 *
 * @author manolovn
 */
public class EdgeDistanceComparator implements Comparable<EdgeDistanceComparator> {

    public Edge edge;
    public double distance;

    public EdgeDistanceComparator(Edge edge, double distance) {
        this.edge = edge;
        this.distance = distance;
    }

    @Override
    public int compareTo(@NonNull EdgeDistanceComparator o) {
        if (o.distance == distance) {
            return 0;
        } else if (o.distance < distance) {
            return 1;
        } else {
            return -1;
        }
    }
}
