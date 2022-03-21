package com.example.ltp.list.page

import com.example.ltp.list.Context
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

class ListPage(context: Context) : Page(context) {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.example.ltp.list:id/toolbar']/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText[@name='List']")
    private lateinit var title: WebElement

    @AndroidFindBy(id = "com.example.ltp.list:id/fab")
    @iOSXCUITFindBy(accessibility = "Add")
    private lateinit var addButton: WebElement

    @AndroidFindBy(id = "com.example.ltp.list:id/text_view_list_item")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText")
    private lateinit var items: MutableList<WebElement>

    fun isDisplayed() = "List" == title.text

    fun pressAddButton(): ItemPage {
        addButton.click()
        return ItemPage(context)
    }

    fun hasItem(item: String) = items.find { it.text == item } != null

}