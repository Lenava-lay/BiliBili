package com.example.bilibili.utils;

import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //禁止横屏


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayout());


    }

    abstract int getLayout();



}
