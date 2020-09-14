package com.example.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.LogRecord;

public class PictureUtil {
    private static ImageView imageView;
    private static String imageUrl;
    private static byte[] imageByte;

    static Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x123) {
                if (imageByte != null) {
                    Bitmap bitma = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length);
                    imageView.setImageBitmap(bitma);
                }
            }
        }
    };

    public void load(ImageView imageView, String imageUrl) {
        this.imageView = imageView;
        this.imageUrl = imageUrl;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null && drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        new Thread(runnable).start();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(10000);
                if (connection.getResponseCode() == 200) {
                    InputStream inputStream = connection.getInputStream();
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    byte[] bytes = new byte[1024];
                    int length = -1;
                    while ((length = inputStream.read(bytes)) != -1) {
                        out.write(bytes, 0, length);
                    }
                    imageByte = out.toByteArray();
                    inputStream.close();
                    out.close();
                    handler.sendEmptyMessage(0x123);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}
