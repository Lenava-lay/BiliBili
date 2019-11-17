package com.example.bilibili.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class ToastUtil extends Toast {

     public static Toast toast;

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public ToastUtil(Context context) {
        super(context);
    }

    public static void makeText(Context context, String text, int shotTime) {

        Log.d("my", "makeText: ");
        if(toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(context, text, shotTime);
        toast.show();
     }
}
