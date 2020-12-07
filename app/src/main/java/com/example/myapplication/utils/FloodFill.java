package com.example.myapplication.utils;

import android.graphics.Bitmap;
import android.graphics.Point;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static void floodFill(Bitmap bitmap, Point point, int targetColor, int newColor) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (targetColor != newColor) {
            Queue<Point> queue = new LinkedList<>();
            do {
                int x = point.x;
                int y = point.y;
                while (x > 0 && bitmap.getPixel(x - 1, y) == targetColor) {
                    x--;
                }
                boolean spanUp = false;
                boolean spanDown = false;
                while (x < width && bitmap.getPixel(x, y) == targetColor) {
                    bitmap.setPixel(x, y, newColor);
                    if (!spanUp && y > 0 && bitmap.getPixel(x, y - 1) == targetColor) {
                        queue.add(new Point(x, y - 1));
                        spanUp = true;
                    } else if (spanUp && y > 0 && bitmap.getPixel(x, y - 1) != targetColor) {
                        spanUp = false;
                    }
                    if (!spanDown && y < height - 1 && bitmap.getPixel(x, y + 1) == targetColor) {
                        queue.add(new Point(x, y + 1));
                        spanDown = true;
                    } else if (spanDown && y < height - 1 && bitmap.getPixel(x, y + 1) != targetColor) {
                        spanDown = false;
                    }
                    x++;

                }


            } while ((point = queue.poll()) != null);
        }
    }

    public static Bitmap floodFillUtil(Bitmap bitmap, int x, int y, int targetColor, int newColor,
                              int width, int height) {
        // Base cases
        if (x < 0 || x >= width || y < 0 || y >= height)
            return bitmap;
        if (bitmap.getPixel(x, y) != targetColor)
            return bitmap;

        // Replace the color at (x, y)
        bitmap.setPixel(x, y, newColor);

        // Recur for north, east, south and west
        bitmap = floodFillUtil(bitmap, x + 1, y, targetColor, newColor, width, height);
        bitmap = floodFillUtil(bitmap, x - 1, y, targetColor, newColor, width, height);
        bitmap = floodFillUtil(bitmap, x, y + 1, targetColor, newColor, width, height);
        bitmap = floodFillUtil(bitmap, x, y - 1, targetColor, newColor, width, height);
        return bitmap;
    }
}
