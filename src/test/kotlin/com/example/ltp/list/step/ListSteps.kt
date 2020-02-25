package com.example.ltp.list.step

import com.example.ltp.list.page.ListPage
import io.cucumber.java8.En
import org.junit.Assert.assertTrue

class ListSteps(listPage: ListPage) : En {

    init {
        val newItem = "Item 1"

        Given("I am on the list page") {
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