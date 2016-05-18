package com.manolovn.trianglify.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.manolovn.trianglify.domain.Point;

import java.util.Vector;

/**
 * Point renderer
 *
 * @author manolovn
 */
public class PointRenderer {

    private int radius = 10;
    private Paint paint = new Paint();

    public PointRenderer() {
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(0);
        paint.setColor(Color.argb(125, 255, 255, 255));
    }

    public void render(Vector<Point> points, Canvas canvas) {
        for (Point point : points) {
            canvas.drawCircle(point.x, point.y, radius, paint);
        }
    }
}

