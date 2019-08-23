package com.example.ltp.list.page

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

abstract class Page(protected val driver: AppiumDriver<MobileElement>) {

    init {
        initElements()
    }

    private fun initElements() {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

}