package com.jiangkang.jetpack.ui.architecture.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.jiangkang.requests.github.GithubService
import com.jiangkang.requests.github.entity.User
import io.reactivex.disposables.CompositeDisposable

class UsersDataSourceFactory(private val compositeDisposable: CompositeDisposable,
                             private val githubService: GithubService)
    : DataSource.Factory<Long, User>() {

    val usersDataSourceLiveData = MutableLiveData<UserDataSource>()

    override fun create(): DataSource<Long, User> {
        val usersDataSource = UserDataSource(githubService, compositeDisposable)
        usersDataSourceLiveData.postValue(usersDataSource)
        return usersDataSource
    }
}