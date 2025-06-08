package com.kotlinprc.cms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class CmsApplication

fun main(args: Array<String>) {
    runApplication<CmsApplication>(*args)
}
