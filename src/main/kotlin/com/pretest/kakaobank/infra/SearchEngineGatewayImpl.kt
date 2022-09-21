package com.pretest.kakaobank.infra

import com.pretest.kakaobank.infra.kakao.KakaoSearchEngine
import org.springframework.stereotype.Component

@Component
class SearchEngineGatewayImpl(
    private val kakaoSearchEngine: KakaoSearchEngine,
    private val dummySearchEngine: DummySearchEngine
) : SearchEngineGateway {

    override fun getSearchEngine(): SearchEngine {
        return if (defaultSearchEngineAvailable()) {
            kakaoSearchEngine
        } else {
            dummySearchEngine
        }
    }

    /**
     * 기본 검색엔진 동작 여부 확인
     */
    fun defaultSearchEngineAvailable() :Boolean {
        return true
    }
}