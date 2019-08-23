package com.example.ltp.list.page

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy

class ItemPage(driver: AppiumDriver<MobileElement>) : Page(driver) {

    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeTextField")
    private lateinit var editField: MobileElement

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Save")
    private lateinit var saveButton: MobileElement

    fun enterItem(item: String): ListPage {
        editField.sendKeys(item)
        saveButton.click()
        return ListPage(driver)
    }

}