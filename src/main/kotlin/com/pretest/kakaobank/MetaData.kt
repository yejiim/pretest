package com.pretest.kakaobank

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * API 응답값 meta data
 */
data class MetaData(
    @JsonProperty("total_count")
    val totalCount: Int,
    @JsonProperty("is_end")
    val isEnd: Boolean,
    @JsonProperty("pageable_count")
    val pageableCount: Int
)