package com.example.bilibiliproject.Items;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bilibili.R;

public class PrettyPictureItemActivity extends AppCompatActivity {
    private TextView textView1;
    boolean isDianzan = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pretty_picture_item);
        textView1 = findViewById(R.id.tv_4);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isDianzan){
                    isDianzan = true;
                    Drawable drawable = getResources().getDrawable(R.drawable.dianzan_1);
                    drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
                    textView1.setCompoundDrawables(drawable,null,null,null);
                }else{
                    isDianzan = false;
                    Drawable drawable = getResources().getDrawable(R.drawable.dianzan);
                    drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
                    textView1.setCompoundDrawables(drawable,null,null,null);
                }

            }
        });
    }
}
