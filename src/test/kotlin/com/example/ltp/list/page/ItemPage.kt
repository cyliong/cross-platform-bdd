package com.example.ltp.list.page

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy

class ItemPage(driver: AppiumDriver<MobileElement>) : Page(driver) {

    @AndroidFindBy(id = "com.example.ltp.list:id/edit_text_item_title")
    @iOSXCUITFindBy(id = "TitleTextField")
    private lateinit var editField: MobileElement

    @AndroidFindBy(id = "com.example.ltp.list:id/action_save")
    @iOSXCUITFindBy(accessibility = "Save")
    private lateinit var saveButton: MobileElement

    fun enterItem(item: String): ListPage {
        editField.sendKeys(item)
        saveButton.click()
        return ListPage(driver)
    }

}