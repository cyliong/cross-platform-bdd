package com.example.ltp.list

import kotlin.time.Duration.Companion.seconds
import kotlin.time.toJavaDuration

class Context {

    val driver by lazy {
        DriverFactory.createDriver().apply {
            manage().timeouts().implicitlyWait(20.seconds.toJavaDuration())
        }
    }

}