package com.anddymao.filterdemo.utils;

import android.graphics.Bitmap;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;


public class Bitmaps {
    public static Bitmap ensureBitmapSize(Bitmap origin) {
        int maxSize = getMaxTextureSize();
        Bitmap resizeBitmap;
        if (origin != null && (origin.getWidth() > maxSize || origin.getHeight() > maxSize)) {
            try {
                if (origin.getWidth() > origin.getHeight()) {
                    resizeBitmap = Bitmap.createScaledBitmap(origin, maxSize, origin.getHeight() * maxSize / origin.getWidth(), true);
                } else {
                    resizeBitmap = Bitmap.createScaledBitmap(origin, origin.getWidth() * maxSize / origin.getHeight(), maxSize, true);
                }
                return resizeBitmap;
            } catch (OutOfMemoryError error) {
                origin = null;
            }
        }
        return origin;
    }

    public static int getMaxTextureSize() {
        // Safe minimum default size
        final int IMAGE_MAX_BITMAP_DIMENSION = 2048;

        // Get EGL Display
        EGL10 egl = (EGL10) EGLContext.getEGL();
        EGLDisplay display = egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);

        // Initialise
        int[] version = new int[2];
        egl.eglInitialize(display, version);

        // Query total number of configurations
        int[] totalConfigurations = new int[1];
        egl.eglGetConfigs(display, null, 0, totalConfigurations);

        // Query actual list configurations
        EGLConfig[] configurationsList = new EGLConfig[totalConfigurations[0]];
        egl.eglGetConfigs(display, configurationsList, totalConfigurations[0], totalConfigurations);

        int[] textureSize = new int[1];
        int maximumTextureSize = 0;

        // Iterate through all the configurations to located the maximum texture size
        for (int i = 0; i < totalConfigurations[0]; i++) {
            // Only need to check for width since opengl textures are always squared
            egl.eglGetConfigAttrib(display, configurationsList[i], EGL10.EGL_MAX_PBUFFER_WIDTH, textureSize);

            // Keep track of the maximum texture size
            if (maximumTextureSize < textureSize[0])
                maximumTextureSize = textureSize[0];
        }

        // Release
        egl.eglTerminate(display);

        // Return largest texture size found, or default
        return Math.max(maximumTextureSize, IMAGE_MAX_BITMAP_DIMENSION);
    }
}
