package com.pretest.kakaobank.config

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.pretest.kakaobank.PretestConstants.Companion.SEOUL_TIME_ZONE
import com.pretest.kakaobank.PretestConstants.Companion.TIME_FORMAT
import java.io.IOException
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * stackOverflow 참고
 * https://stackoverflow.com/questions/57182346/deserialize-json-date-format-to-zoneddatetime-using-objectmapper
 */
class ZonedDateTimeDeserializer() : JsonDeserializer<ZonedDateTime?>() {

    @Throws(IOException::class)
    override fun deserialize(
        jsonParser: JsonParser,
        deserializationContext: DeserializationContext?
    ): ZonedDateTime {

        val localDate = LocalDate.parse(
            jsonParser.getText(),
            DateTimeFormatter.ofPattern(TIME_FORMAT)
        )
        return localDate.atStartOfDay(ZoneOffset.of(SEOUL_TIME_ZONE))
    }
}

