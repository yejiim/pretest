package com.pretest.kakaobank.config

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.io.IOException
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * stackOverflow 참고
 */
class ZonedDateTimeDeserializer(format: String) : JsonDeserializer<ZonedDateTime?>() {
    private val TIME_FORMAT = format
    @Throws(IOException::class)
    override fun deserialize(
        jsonParser: JsonParser,
        deserializationContext: DeserializationContext?
    ): ZonedDateTime {

        val localDate = LocalDate.parse(
            jsonParser.getText(),
            DateTimeFormatter.ofPattern(TIME_FORMAT)
        )
        return localDate.atStartOfDay(ZoneOffset.of("+09:00"))
    }
}

