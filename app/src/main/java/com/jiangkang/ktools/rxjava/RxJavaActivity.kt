package com.jiangkang.ktools.rxjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jiangkang.ktools.DownloadActivity
import com.jiangkang.ktools.rxjava.fragments.RxJavaFragment


class RxJavaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentManager
                .beginTransaction()
                .replace(android.R.id.content, RxJavaFragment(), this.toString())
                .commit()
    }





}

