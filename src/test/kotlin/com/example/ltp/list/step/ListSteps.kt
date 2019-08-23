package com.example.ltp.list.step

import com.example.ltp.list.page.ListPage
import org.junit.Assert.assertTrue

class ListSteps : Steps() {

    init {
        val newItem = "Item 1"
        lateinit var listPage: ListPage

        Given("I am on the list page") {
            listPage = ListPage(driver)
            assertTrue(listPage.isDisplayed())
        }

        When("I add a new item") {
            listPage
                .pressAddButton()
                .enterItem(newItem)
        }

        Then("I should see the new item on the list") {
            assertTrue(listPage.hasItem(newItem))
        }
    }

}