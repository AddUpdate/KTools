package com.jiangkang.jetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jiangkang.jetpack.repository.GithubRepository

class GithubTrendViewModelFactory(private val repository: GithubRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GithubTrendViewModel(repository) as T
    }
}