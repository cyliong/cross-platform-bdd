package com.example.ltp.list.page

import com.example.ltp.list.Context
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

class ItemPage(context: Context) : Page(context) {

    @AndroidFindBy(id = "com.example.ltp.list:id/edit_text_item_title")
    @iOSXCUITFindBy(id = "TitleTextField")
    private lateinit var editField: WebElement

    @AndroidFindBy(id = "com.example.ltp.list:id/action_save")
    @iOSXCUITFindBy(accessibility = "Save")
    private lateinit var saveButton: WebElement

    fun enterItem(item: String): ListPage {
        editField.sendKeys(item)
        saveButton.click()
        return ListPage(context)
    }

}