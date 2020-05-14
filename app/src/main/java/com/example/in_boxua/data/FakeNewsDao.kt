package com.example.in_boxua.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeNewsDao {

    private val newsListLiveData = MutableLiveData<List<News>>()
    private val newsList = mutableListOf<News>()

    init {
        newsListLiveData.value = newsList
    }

    //Add/get news
    fun addNews(news: News) {
        newsList.add(news)
        newsListLiveData.value = newsList
    }

    fun getNewsList() = newsListLiveData as LiveData<List<News>>
}