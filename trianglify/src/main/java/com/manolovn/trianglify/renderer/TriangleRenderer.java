package com.manolovn.trianglify.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.manolovn.trianglify.domain.Triangle;
import com.manolovn.trianglify.generator.color.ColorGenerator;
import com.manolovn.trianglify.generator.color.RandomColorGenerator;

import java.util.Collection;

/**
 * Triangle renderer
 *
 * @author manolovn
 */
public class TriangleRenderer {

    private Paint trianglePaint;
    private ColorGenerator colorGenerator;

    private Path path;

    public TriangleRenderer() {
        initPaint();
    }

    public TriangleRenderer(ColorGenerator colorGenerator) {
        this.colorGenerator = colorGenerator;

        initPaint();
    }

    private void initPaint() {
        trianglePaint = new Paint();
        trianglePaint.setStyle(Paint.Style.FILL);
        trianglePaint.setAntiAlias(true);

        if (colorGenerator == null) {
            colorGenerator = new RandomColorGenerator();
        }

        path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
    }

    public void render(Collection<Triangle> triangles, Canvas canvas) {
        colorGenerator.setCount(triangles.size());
        for (Triangle triangle : triangles) {
            path.reset();

            path.moveTo(triangle.a.x, triangle.a.y);
            path.lineTo(triangle.b.x, triangle.b.y);
            path.lineTo(triangle.c.x, triangle.c.y);
            path.lineTo(triangle.a.x, triangle.a.y);

            path.close();

            trianglePaint.setColor(colorGenerator.nextColor());
            canvas.drawPath(path, trianglePaint);
        }
    }
}
