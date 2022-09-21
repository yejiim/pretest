package com.pretest.kakaobank.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.pretest.kakaobank.PretestConstants.Companion.TIME_FORMAT
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


@Configuration
class WebClientConfig {

    @Bean
    fun webClient(objectMapper: ObjectMapper): WebClient {
        val jsonStrategies = ExchangeStrategies.builder().codecs {
            it.defaultCodecs().jackson2JsonEncoder(Jackson2JsonEncoder(objectMapper, MediaType.APPLICATION_JSON))
            it.defaultCodecs().jackson2JsonDecoder(Jackson2JsonDecoder(objectMapper, MediaType.APPLICATION_JSON))

        }.build()
        return WebClient.builder().exchangeStrategies(jsonStrategies).build()
    }

    @Bean
    fun objectMapper(): ObjectMapper {

        return ObjectMapper().registerModules(
            KotlinModule(),
            JavaTimeModule().addSerializer(
                ZonedDateTime::class.java,
                ZonedDateTimeSerializer(DateTimeFormatter.ofPattern(TIME_FORMAT))
            ),
            SimpleModule().addDeserializer(ZonedDateTime::class.java, ZonedDateTimeDeserializer())
        )

    }
}