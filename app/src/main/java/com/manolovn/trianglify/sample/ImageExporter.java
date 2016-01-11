package com.manolovn.trianglify.sample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Simple image exporter
 */
public class ImageExporter {

    private static final String ALBUM_NAME = "Trianglify";

    private FileOutputStream fos;
    private Bitmap bitmap;

    public ImageExporter() {
    }

    public void exportFromView(Context context, View view) throws IOException {
        File mediaStorageDir = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                ALBUM_NAME);
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return;
            }
        }

        view.setDrawingCacheEnabled(true);
        bitmap = view.getDrawingCache(true);

        File file = null;
        int number = 1;
        boolean creating = true;
        while (creating) {
            String imageName = String.format("%05d", number);
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/" + ALBUM_NAME
                    + "/" + imageName + ".png");

            if (file.exists()) {
                number++;
            } else {
                creating = false;
            }
        }
        
        fos = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);

        fos.flush();
        fos.close();

        file.createNewFile();
        galleryAddPic(context, file.getPath());
    }

    public void galleryAddPic(Context context, String path) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(path);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        context.sendBroadcast(mediaScanIntent);
    }
}
