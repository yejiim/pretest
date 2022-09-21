package com.pretest.kakaobank.search.repository

import com.pretest.kakaobank.search.entity.QueryCount

interface SearchRepositoryCustom {
    fun getTrendingQueries() : List<QueryCount>
}