package com.example.in_boxua.data

class NewsRepository private constructor(private val newsDao: FakeNewsDao) {

    fun addNews(news: News) {
        newsDao.addNews(news)
    }

    fun getNews() = newsDao.getNewsList()

    companion object {

        @Volatile
        private var instance: NewsRepository? = null

        fun getInstance(newsDao: FakeNewsDao) =
            instance ?: synchronized(this) {
                instance ?: NewsRepository(newsDao).also { instance = it }
            }
    }
}