package com.pretest.kakaobank.infra

import org.springframework.stereotype.Component

@Component
interface SearchEngineGateway {

    fun getSearchEngine(): SearchEngine
}