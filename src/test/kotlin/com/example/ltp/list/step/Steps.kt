package com.example.ltp.list.step

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.remote.MobilePlatform
import io.cucumber.core.api.Scenario
import io.cucumber.java8.En
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.util.concurrent.TimeUnit

open class Steps : En {

    protected lateinit var driver: AppiumDriver<MobileElement>

    init {
        Before { _: Scenario ->
            val serviceUrl = URL("http://localhost:4723/wd/hub")
            DesiredCapabilities().apply {
                driver = if (System.getProperty("platform") == "ios") {
                    setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS)
                    setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4")
                    setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Xs")
                    setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest")
                    setCapability(MobileCapabilityType.APP, "/path/to/List.app")
                    IOSDriver(serviceUrl, this)
                } else {
                    setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID)
                    setCapability(MobileCapabilityType.PLATFORM_VERSION, "9")
                    setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator")
                    setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
                    setCapability(MobileCapabilityType.APP, "/path/to/list.apk")
                    AndroidDriver(serviceUrl, this)
                }
            }
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
        }

        After { _: Scenario ->
            driver.quit()
        }
    }

}