package com.pretest.kakaobank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.pretest"])
class KakaobankApplication

fun main(args: Array<String>) {
    runApplication<KakaobankApplication>(*args)
}
