package com.jiangkang.ktools;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jiangkang.annotations.apt.Router;

@Router
public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
//        AboutPageViewModel viewModel = new AboutPageViewModel(this);
//        viewModel.setAuthor("姜康").setSourceUrl("https://github.com/jiangkang/KTools");
//        binding.setVm(viewModel);
    }
}
