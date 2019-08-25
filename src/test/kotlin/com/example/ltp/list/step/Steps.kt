package com.example.ltp.list.step

import com.example.ltp.list.DriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.cucumber.core.api.Scenario
import io.cucumber.java8.En
import java.util.concurrent.TimeUnit

open class Steps : En {

    protected lateinit var driver: AppiumDriver<MobileElement>

    init {
        Before { _: Scenario ->
            driver = DriverFactory.createDriver()
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
        }

        After { _: Scenario ->
            driver.quit()
        }
    }

}