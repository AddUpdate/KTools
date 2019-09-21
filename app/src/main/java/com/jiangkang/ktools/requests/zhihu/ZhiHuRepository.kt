package com.jiangkang.ktools.requests.zhihu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Log
import com.jiangkang.requests.KRequests
import com.jiangkang.requests.dsl.RequestWrapper
import com.jiangkang.requests.zhihu.ZhihuApi
import com.jiangkang.requests.zhihu.bean.Story
import com.jiangkang.tools.utils.LogUtils
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by jiangkang on 2018/1/17.
 * description：
 */

object ZhiHuRepository {

    public fun getZhiHuStoryList(): LiveData<ArrayList<Story>> {
        val data = MutableLiveData<ArrayList<Story>>()

        KRequests.request(ZhihuApi::class.java).latestNews
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    data.value = it.stories
                }
        queryLatestDailyNews()

        return data

    }

    private fun queryLatestDailyNews(){
        RequestWrapper().apply {
            fetch {
                url = "http://news-at.zhihu.com/api/4/news/latest"
                method = "GET"
                onSuccess {
                    response -> LogUtils.d("http", response.body!!.string())
                }
                onFailed {
                    t -> LogUtils.d("http",t.message)
                }
            }
        }
    }

}