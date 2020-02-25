package com.example.ltp.list.page

import com.example.ltp.list.Context
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

abstract class Page(protected val context: Context) {

    init {
        initElements()
    }

    private fun initElements() {
        PageFactory.initElements(AppiumFieldDecorator(context.driver), this)
    }

}