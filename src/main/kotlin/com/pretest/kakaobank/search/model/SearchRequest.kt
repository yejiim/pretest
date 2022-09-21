package com.pretest.kakaobank.search.model

import com.pretest.kakaobank.search.enums.Sort

data class SearchRequest(
    val sort: String = Sort.ACCURACY.name,
    val query: String,
    val page: Int = 1,
    val size: Int = 10
)