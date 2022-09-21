package com.pretest.kakaobank.search.controller

import com.pretest.kakaobank.search.model.SearchRequest
import com.pretest.kakaobank.search.model.SearchResponse
import com.pretest.kakaobank.search.model.TrendingKeywordsResponse
import com.pretest.kakaobank.search.service.SearchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/search")
class SearchController(
    private val searchService: SearchService
) {
    /**
     * 블로그 검색
     */
    @GetMapping("blog")
    fun searchBlog(request: SearchRequest): SearchResponse {
        request.validate()
        return searchService.blogSearch(request)
    }

    /**
     * 인기검색어 조회
     */
    @GetMapping("trending")
    fun listTrendingKeywords() : TrendingKeywordsResponse? {
        return searchService.trending()
    }
}