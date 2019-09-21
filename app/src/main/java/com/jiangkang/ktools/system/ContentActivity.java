package com.jiangkang.ktools.system;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.jiangkang.ktools.R;

public class ContentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        getContactList();
    }

    private void getContactList() {

    }


}
