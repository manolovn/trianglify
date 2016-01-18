package com.manolovn.sample.exporter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Simple image exporter
 */
public class ImageExporter {

    private static final String ALBUM_NAME = "Trianglify";

    public ImageExporter() {
    }

    public void exportFromView(final Context context, final View view) throws IOException {
        File folder = FileUtils.getOrCreateFolder(ALBUM_NAME);

        Bitmap bitmap = view.getDrawingCache(true);

        File file = null;
        int number = 1;
        boolean creating = true;
        while (creating) {
            String imageName = String.format("%05d", number);
            file = new File(folder + "/" + imageName + ".png");

            if (file.exists()) {
                number++;
            } else {
                creating = false;
            }
        }

        FileOutputStream fos = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);

        fos.flush();
        fos.close();

        file.createNewFile();
        FileUtils.scanForFile(context, file.getPath());
    }
}
