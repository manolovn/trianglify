package com.manolovn.trianglify.sample;

import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Simple image exporter
 */
public class ImageExporter {

    private FileOutputStream fos;
    private Bitmap bitmap;

    public ImageExporter() {
    }

    public void exportFromView(View view) throws IOException {
        view.setDrawingCacheEnabled(true);
        bitmap = view.getDrawingCache(true);

        fos = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + "/001.png");
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);

        fos.flush();
        fos.close();
    }
}
