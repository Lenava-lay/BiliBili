package com.example.bilibili.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.WindowManager;

import com.example.bilibili.MainActivity;
import com.example.bilibili.R;
import com.example.bilibili.utils.ThreadUtils;

public class StartPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置标题栏隐藏
//        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_start_page);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ThreadUtils.setInThread(() -> {

            // 界面停留三秒钟
            SystemClock.sleep(1000);

            // 界面跳转到指定界面
            Intent intent = new Intent(StartPageActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

}
