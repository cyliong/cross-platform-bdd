package com.example.ltp.list

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.remote.MobilePlatform
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

class DriverFactory {

    companion object {
        private val serviceUrl = URL("http://localhost:4723/wd/hub")

        fun createDriver(): AppiumDriver<MobileElement> {
            if (System.getProperty("platform") == "ios") {
                val capabilities = DesiredCapabilities().apply {
                    setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS)
                    setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.5")
                    setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro")
                    setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest")
                    setCapability(MobileCapabilityType.APP, "/path/to/List.app")
                }
                return IOSDriver(serviceUrl, capabilities)
            } else {
                val capabilities = DesiredCapabilities().apply {
                    setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID)
                    setCapability(MobileCapabilityType.PLATFORM_VERSION, "9")
                    setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator")
                    setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
                    setCapability(MobileCapabilityType.APP, "/path/to/list.apk")
                }
                return AndroidDriver(serviceUrl, capabilities)
            }
        }

    }

}