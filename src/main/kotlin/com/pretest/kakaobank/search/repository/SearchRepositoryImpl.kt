package com.pretest.kakaobank.search.repository

import com.pretest.kakaobank.search.entity.QQueryCount
import com.pretest.kakaobank.search.entity.QueryCount
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

class SearchRepositoryImpl : QuerydslRepositorySupport(QueryCount::class.java), SearchRepositoryCustom {

    val queryCount = QQueryCount.queryCount

    override fun getTrendingQueries(): List<QueryCount> {
        return from(queryCount)
            .orderBy(queryCount.count.desc())
            .limit(10)
            .fetch()
    }
}