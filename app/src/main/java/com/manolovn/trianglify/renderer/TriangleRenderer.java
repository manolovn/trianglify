package com.manolovn.trianglify.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.manolovn.trianglify.color.BrewerColorGenerator;
import com.manolovn.trianglify.color.ColorGenerator;
import com.manolovn.trianglify.triangle.Triangle;

import java.util.Collection;

/**
 * Triangle renderer
 *
 * @author manolovn
 */
public class TriangleRenderer {

    private Paint trianglePaint;
    private ColorGenerator colorGenerator;

    public TriangleRenderer() {
        initPaint();
        colorGenerator = new BrewerColorGenerator();
    }

    public TriangleRenderer(ColorGenerator colorGenerator) {
        this.colorGenerator = colorGenerator;
    }

    private void initPaint() {
        trianglePaint = new Paint();
        trianglePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        trianglePaint.setAntiAlias(true);
        trianglePaint.setStrokeWidth(5);
    }

    public void render(Collection<Triangle> triangles, Canvas canvas) {
        int i = 0;
        for (Triangle triangle : triangles) {
            if(i > 100) {
                continue;
            }

            Path path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);

            path.moveTo(triangle.a.x, triangle.a.y);
            path.lineTo(triangle.b.x, triangle.b.y);
            path.lineTo(triangle.c.x, triangle.c.y);
            path.lineTo(triangle.a.x, triangle.a.y);

            path.close();

            trianglePaint.setColor(colorGenerator.nextColor());
            canvas.drawPath(path, trianglePaint);

            i++;
        }
    }
}
