package com.pretest.kakaobank.search.model

import com.pretest.kakaobank.search.entity.QueryCount

data class TrendingKeywordsResponse(
    val list: List<QueryCountModel>
) {
    companion object {
        fun of(queryCountList: List<QueryCount>): TrendingKeywordsResponse {
            return TrendingKeywordsResponse(
                list = queryCountList.map {
                    QueryCountModel(it.query, it.count)
                }
            )
        }
    }
}

//FIXME change to a better name
data class QueryCountModel(
    val query: String,
    val count: Int
)