package com.manolovn.trianglify;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import com.manolovn.trianglify.domain.Point;
import com.manolovn.trianglify.domain.Triangle;
import com.manolovn.trianglify.generator.color.ColorGenerator;
import com.manolovn.trianglify.generator.point.PointGenerator;
import com.manolovn.trianglify.renderer.TriangleRenderer;
import com.manolovn.trianglify.triangulator.DelaunayTriangulator;
import com.manolovn.trianglify.triangulator.Triangulator;

import java.util.Vector;

/**
 * Trianglify drawable
 *
 * @author doug
 */
public class TrianglifyDrawable extends Drawable {

    private PointGenerator pointGenerator;
    private Triangulator triangulator;
    private TriangleRenderer triangleRenderer;

    private int width;
    private int height;
    private int bleedX;
    private int bleedY;
    private int cellSize;
    private int variance;

    private Vector<Point> points;
    private Vector<Triangle> triangles;

    private final Object lock = new Object();
    // Used with triangulateInBackground
    Boolean ready = false;

    public TrianglifyDrawable(
            int bleedX,
            int bleedY,
            int cellSize,
            int variance,
            ColorGenerator colorGenerator,
            PointGenerator pointGenerator) {
        super();

        this.bleedX = bleedX;
        this.bleedY = bleedY;
        this.cellSize = cellSize;
        this.variance = variance;
        this.pointGenerator = pointGenerator;

        triangulator = new DelaunayTriangulator();
        triangleRenderer = new TriangleRenderer(colorGenerator);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        this.width = bounds.width();
        this.height = bounds.height();
        triangulateInBackground();
    }

    @Override
    public void draw(Canvas canvas) {
        if (ready) {
            triangleRenderer.render(triangles, canvas);
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }

    public void setVariance(int variance) {
        this.variance = variance;
        triangulateInBackground();
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
        triangulateInBackground();
    }

    public void setColorGenerator(ColorGenerator colorGenerator) {
        triangleRenderer = new TriangleRenderer(colorGenerator);
        triangulateInBackground();
    }

    public void setPointGenerator(PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
        triangulateInBackground();
    }

    private void triangulateInBackground() {
        TriangulateAsyncTask task = new TriangulateAsyncTask();
        task.execute();
    }

    private class TriangulateAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            synchronized (lock) {
                ready = false;
                pointGenerator.setBleedX(bleedX);
                pointGenerator.setBleedY(bleedY);
                points = pointGenerator.generatePoints(width, height, cellSize, variance);
                triangles = triangulator.triangulate(points);
                ready = true;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            invalidateSelf();
        }
    }

}
