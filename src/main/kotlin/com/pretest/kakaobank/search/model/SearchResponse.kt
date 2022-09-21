package com.pretest.kakaobank.search.model

import com.pretest.kakaobank.Document
import com.pretest.kakaobank.MetaData

data class SearchResponse(
    val meta: MetaData,
    val documents: List<Document>
)