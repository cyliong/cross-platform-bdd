package com.example.ltp.list.step

import com.example.ltp.list.page.ListPage
import io.cucumber.java8.En
import org.junit.Assert.assertTrue

class ListSteps(listPage: ListPage) : En {

    init {
        Given("I am on the list page") {
            assertTrue(listPage.isDisplayed())
        }

        When("I add a new item {string}") { item: String ->
            listPage
                .pressAddButton()
                .enterItem(item)
        }

        Then("I should see {string} on the list") { item: String ->
            assertTrue(listPage.hasItem(item))
        }
    }

}