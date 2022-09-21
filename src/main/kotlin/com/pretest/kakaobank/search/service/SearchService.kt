package com.pretest.kakaobank.search.service

import com.pretest.kakaobank.infra.SearchEngineGateway
import com.pretest.kakaobank.search.entity.QueryCount
import com.pretest.kakaobank.search.model.SearchRequest
import com.pretest.kakaobank.search.model.SearchResponse
import com.pretest.kakaobank.search.model.TrendingKeywordsResponse
import com.pretest.kakaobank.search.repository.SearchRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class SearchService(
    private val searchEngineGateway: SearchEngineGateway,
    private val repository: SearchRepository
) {
    //FIXME 이걸 aspect로? 여튼 좀 더 좋은 방법으로..
    fun blogSearch(request: SearchRequest): SearchResponse {
        updateKeyword(request.query)
        return searchEngineGateway.getSearchEngine().blogSearch(request)
    }

    // TODO view table 단순 조회
    fun trending(): TrendingKeywordsResponse? {
        return TrendingKeywordsResponse.of(repository.getTrendingQueries())
    }

    @Transactional
    fun updateKeyword(query: String) {
        val entity: QueryCount = repository.findByQuery(query)?.apply {
            this.update()
        } ?: QueryCount(query = query).apply {
            this.update()
        }
        repository.save(entity)
    }
}