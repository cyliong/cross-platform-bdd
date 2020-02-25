package com.example.ltp.list.page

import com.example.ltp.list.Context
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy

class ItemPage(context: Context) : Page(context) {

    @AndroidFindBy(id = "com.example.ltp.list:id/edit_text_item_title")
    @iOSXCUITFindBy(id = "TitleTextField")
    private lateinit var editField: MobileElement

    @AndroidFindBy(id = "com.example.ltp.list:id/action_save")
    @iOSXCUITFindBy(accessibility = "Save")
    private lateinit var saveButton: MobileElement

    fun enterItem(item: String): ListPage {
        editField.sendKeys(item)
        saveButton.click()
        return ListPage(context)
    }

}