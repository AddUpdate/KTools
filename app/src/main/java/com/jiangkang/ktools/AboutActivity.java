package com.jiangkang.ktools;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jiangkang.annotations.apt.Router;
import com.jiangkang.hybrid.Khybrid;

@Router
public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        findViewById(R.id.tv_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Khybrid().loadUrl(AboutActivity.this,"https://github.com/jiangkang/KTools");
            }
        });
    }
}
