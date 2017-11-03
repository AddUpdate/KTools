package com.jiangkang.ktools;

import android.app.Application;
import android.content.Intent;

import com.jiangkang.tools.King;
import com.jiangkang.tools.service.ScanMusicService;
import com.squareup.leakcanary.LeakCanary;

/**
 *
 * @author jiangkang
 * @date 2017/9/6
 */
public class KApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
        King.init(this);

    }


}
