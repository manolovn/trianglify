package com.manolovn.trianglify;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.manolovn.trianglify.generator.color.ColorGenerator;

import java.lang.reflect.Constructor;

/**
 * Trianglify view
 *
 * @author manolovn
 */
public class TrianglifyView extends View {

    private TrianglifyDrawable drawable;

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
        ColorGenerator colorGenerator = Default.colorGenerator;
        int cellSize = Default.cellSize;
        int variance = Default.variance;
        int bleedX = Default.bleedX;
        int bleedY = Default.bleedY;

        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs,
                    R.styleable.TrianglifyView, 0, 0);

            try {
                cellSize = a.getInteger(R.styleable.TrianglifyView_cellSize, cellSize);
                variance = a.getInteger(R.styleable.TrianglifyView_variance, variance);
                bleedX = a.getInteger(R.styleable.TrianglifyView_bleedX, bleedX);
                bleedY = a.getInteger(R.styleable.TrianglifyView_bleedY, bleedY);
                colorGenerator = getColorGeneratorByName(
                        a.getString(R.styleable.TrianglifyView_colorGenerator));
            } finally {
                a.recycle();
            }
        }

        drawable = new TrianglifyDrawable(cellSize, variance, bleedX, bleedY, colorGenerator);
        setBackgroundDrawable(drawable);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public TrianglifyDrawable getDrawable() {
        return drawable;
    }

    private ColorGenerator getColorGeneratorByName(String className) {
        if (className == null || className.isEmpty()) {
            return null;
        }
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor();
            Object instace = constructor.newInstance();
            if (instace instanceof ColorGenerator) {
                return (ColorGenerator) instace;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
