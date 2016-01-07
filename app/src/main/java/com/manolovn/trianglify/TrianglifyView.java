package com.manolovn.trianglify;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.manolovn.trianglify.point.Point;
import com.manolovn.trianglify.point.PointGenerator;
import com.manolovn.trianglify.point.RegularPointGenerator;
import com.manolovn.trianglify.renderer.TriangleRenderer;
import com.manolovn.trianglify.triangle.Triangle;
import com.manolovn.trianglify.triangulator.DelaunayTriangulator;
import com.manolovn.trianglify.triangulator.Triangulator;

import java.util.Vector;

/**
 * Trianglify view
 */
public class TrianglifyView extends View {

    private PointGenerator pointGenerator;
    private Triangulator triangulator;
    private TriangleRenderer triangleRenderer;

    private int cellSize = 200;
    private int variance = 50;

    private Vector<Point> points;
    private Vector<Triangle> triangles;

    public TrianglifyView(Context context) {
        super(context);
        init(null);
    }

    public TrianglifyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TrianglifyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            parseAttributes();
        }

        pointGenerator = new RegularPointGenerator(cellSize, variance);
        triangulator = new DelaunayTriangulator();
        triangleRenderer = new TriangleRenderer();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        pointGenerator.setBleedX(50);
        pointGenerator.setBleedY(50);
        points = pointGenerator.generatePoints(width, height);
        triangles = triangulator.triangulate(points);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        triangleRenderer.render(triangles, canvas);
    }

    private void parseAttributes() {
        // TODO: parse attributes
    }
}
