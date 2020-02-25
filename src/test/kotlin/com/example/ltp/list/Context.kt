package com.example.ltp.list

import java.util.concurrent.TimeUnit

class Context {

    val driver by lazy {
        DriverFactory.createDriver().apply {
            manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
        }
    }

}