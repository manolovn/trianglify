package com.manolovn.trianglify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.manolovn.trianglify.color.ColorGenerator;
import com.manolovn.trianglify.color.RandomColorGenerator;
import com.manolovn.trianglify.point.Point;
import com.manolovn.trianglify.point.PointGenerator;
import com.manolovn.trianglify.point.RegularPointGenerator;
import com.manolovn.trianglify.triangle.Triangle;
import com.manolovn.trianglify.triangulator.DelaunayTriangulator;
import com.manolovn.trianglify.triangulator.Triangulator;

import java.util.Iterator;
import java.util.Vector;

/**
 * Trianglify view
 */
public class TrianglifyView extends View {

    private PointGenerator pointGenerator;
    private Triangulator triangulator;
    private ColorGenerator colorGenerator;

    private int cellSize = 200;
    private int variance = 30;

    private int width;
    private int height;
    private int cellsX;
    private int cellsY;
    private int bleedX;
    private int bleedY;
    private Paint paint;
    private Paint linePaint;

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

        colorGenerator = new RandomColorGenerator();
        pointGenerator = new RegularPointGenerator(cellSize, variance);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);

        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setColor(Color.BLACK);
        linePaint.setStrokeWidth(2);
        linePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = getMeasuredWidth();
        height = getMeasuredHeight();

        cellsX = (int) Math.floor((width + 4 * cellSize) / cellSize);
        cellsY = (int) Math.floor((height + 4 * cellSize) / cellSize);

        bleedX = ((cellsX * cellSize) - width) / 2;
        bleedY = ((cellsY * cellSize) - height) / 2;

        pointGenerator.setBleedX(bleedX);
        pointGenerator.setBleedY(bleedY);
        points = pointGenerator.generatePoints(width, height);

        triangulator = new DelaunayTriangulator(points);
        triangulator.triangulate();
        triangles = triangulator.getTriangles();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        renderTriangles(canvas, triangles);
    }

    private void renderTriangles(Canvas canvas, Vector<Triangle> triangles) {
        for (Triangle triangle : triangles) {
            Path path = new Path();

            path.moveTo(triangle.a.x, triangle.a.y);

            path.lineTo(triangle.b.x, triangle.b.y);
            path.moveTo(triangle.b.x, triangle.b.y);

            path.lineTo(triangle.c.x, triangle.c.y);
            path.moveTo(triangle.c.x, triangle.c.y);

            path.lineTo(triangle.a.x, triangle.a.y);

            path.close();

            linePaint.setColor(colorGenerator.nextColor());
            canvas.drawPath(path, linePaint);
        }
    }

    private void parseAttributes() {

    }
}
