package com.pretest.kakaobank.infra

import com.pretest.kakaobank.Document
import com.pretest.kakaobank.MetaData
import com.pretest.kakaobank.search.model.SearchRequest
import com.pretest.kakaobank.search.model.SearchResponse
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

/**
 * dummy search engine
 */
@Component
class DummySearchEngine : SearchEngine {
    override fun blogSearch(request: SearchRequest): SearchResponse {
        return getDummyResult()
    }

    private fun getDummyResult(): SearchResponse {
        return SearchResponse(
            meta = MetaData(0, false, 0),
            documents = listOf(
                Document(
                    "dummy",
                    "dummy-contents",
                    "url",
                    "dummy-blog",
                    "dummy-thumbnail",
                    ZonedDateTime.now().toString()
                )
            )
        )
    }
}