package com.manolovn.trianglify;

import java.util.Vector;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import com.manolovn.colorbrewer.ColorBrewer;
import com.manolovn.trianglify.domain.Point;
import com.manolovn.trianglify.domain.Triangle;
import com.manolovn.trianglify.generator.color.BrewerColorGenerator;
import com.manolovn.trianglify.generator.point.RegularPointGenerator;
import com.manolovn.trianglify.renderer.TriangleRenderer;
import com.manolovn.trianglify.triangulator.DelaunayTriangulator;
import com.manolovn.trianglify.triangulator.Triangulator;

/**
 * Created by doug on 3/17/16.
 */
public class TrianglifyDrawable extends Drawable {

	private RegularPointGenerator pointGenerator;
	private Triangulator triangulator;
	private TriangleRenderer triangleRenderer;

	private int width;
	private int height;

	private Vector<Point> points;
	private Vector<Triangle> triangles;

	// Used with triangulateInBackground
	Boolean ready = false;

	public TrianglifyDrawable(int cellSize, int variance, int bleedX, int bleedY) {
		super();

		pointGenerator = new RegularPointGenerator(cellSize, variance);
		pointGenerator.setBleedX(bleedX);
		pointGenerator.setBleedY(bleedY);
		triangulator = new DelaunayTriangulator();
		triangleRenderer = new TriangleRenderer();
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
		pointGenerator.setVariance(variance);
		triangulateInBackground();
	}

	public void setCellSize(int cellSize) {
		pointGenerator.setCellSize(cellSize);
		triangulateInBackground();
	}

	public void setColor(ColorBrewer color) {
		triangleRenderer = new TriangleRenderer(new BrewerColorGenerator(color));
		triangulateInBackground();
	}

	private void triangulateInBackground() {
		TriangulateAsyncTask task = new TriangulateAsyncTask();
		task.execute();
	}

	private Object lock = new Object();

	private class TriangulateAsyncTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			synchronized (lock) {
				ready = false;
				points = pointGenerator.generatePoints(width, height);
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
