package com.pretest.kakaobank.infra.kakao

import com.pretest.kakaobank.Document
import com.pretest.kakaobank.MetaData
import com.pretest.kakaobank.infra.SearchEngine
import com.pretest.kakaobank.infra.SearchProperties
import com.pretest.kakaobank.search.model.SearchRequest
import com.pretest.kakaobank.search.model.SearchResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Service
class KakaoSearchEngine(
    private val properties: SearchProperties,
    private val webClient: WebClient
) : SearchEngine {

    override fun blogSearch(request: SearchRequest): SearchResponse {

        return webClient.get()
            .uri { builder ->
                builder
                    .scheme("https")
                    .host(properties.host)
                    .path(properties.uri)
                    .queryParam("query", request.query)
                    .queryParam("sort", request.sort)
                    .queryParam("page", request.page)
                    .queryParam("size", request.size)
                    .build()
            }.header("Authorization", properties.key)
            .retrieve()
            .bodyToMono<KakaoSearchResponse>()
            .block()
            .let {
                it.toSearchResponse()
            }
    }
}

data class KakaoSearchResponse(
    val meta: MetaData,
    val documents: List<Document>
) {
    fun toSearchResponse(): SearchResponse {
        return SearchResponse(
            meta = with(this.meta) {
                MetaData(
                    totalCount = this.totalCount,
                    isEnd = this.isEnd,
                    pageableCount = this.pageableCount
                )
            },
            documents = documents.map {
                Document(
                    title = it.title,
                    contents = it.contents,
                    url = it.url,
                    blogname = it.blogname,
                    thumbnail = it.thumbnail,
                    datetime = it.datetime
                )
            }
        )
    }
}