package com.pretest.kakaobank.infra

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("spring.search")
class SearchProperties {
    lateinit var key: String
    lateinit var uri: String
    lateinit var host: String
}