package com.chat.laptop.hivego.typeface;

import android.app.Application;

/**
 * Created by Netforce on 10/25/2016.
 */

public class Hivego extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HivegoUtil.overrideFont(getApplicationContext(), "SERIF", "Lato-Regular.ttf");
        // TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Pacifico.ttf");
    }
}
