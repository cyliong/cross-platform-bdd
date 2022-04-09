package com.example.ltp.list

import java.time.Duration

class Context {

    val driver by lazy {
        DriverFactory.createDriver().apply {
            manage().timeouts().implicitlyWait(Duration.ofSeconds(20))
        }
    }

}