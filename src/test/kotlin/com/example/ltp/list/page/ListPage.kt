package com.example.ltp.list.page

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy

class ListPage(driver: AppiumDriver<MobileElement>) : Page(driver) {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.example.ltp.list:id/toolbar']/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText[@name='List']")
    private lateinit var title: MobileElement

    @AndroidFindBy(id = "com.example.ltp.list:id/fab")
    @iOSXCUITFindBy(accessibility = "Add")
    private lateinit var addButton: MobileElement

    @AndroidFindBy(id = "com.example.ltp.list:id/text_view_list_item")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText")
    private lateinit var items: MutableList<MobileElement>

    fun isDisplayed() = "List" == title.text

    fun pressAddButton(): ItemPage {
        addButton.click()
        return ItemPage(driver)
    }

    fun hasItem(item: String) = items.find { it.text == item } != null

}