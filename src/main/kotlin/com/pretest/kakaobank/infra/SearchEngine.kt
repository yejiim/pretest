package com.pretest.kakaobank.infra

import com.pretest.kakaobank.search.model.SearchRequest
import com.pretest.kakaobank.search.model.SearchResponse

interface SearchEngine {
    fun blogSearch(request: SearchRequest): SearchResponse
}