package com.example.ltp.list.step

import com.example.ltp.list.DriverFactory
import com.example.ltp.list.page.ListPage
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.junit.Assert.assertTrue
import java.util.concurrent.TimeUnit

class ListSteps : En {

    init {
        val newItem = "Item 1"

        lateinit var driver: AppiumDriver<MobileElement>
        lateinit var listPage: ListPage

        Before { _: Scenario ->
            driver = DriverFactory.createDriver()
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
        }

        After { _: Scenario ->
            driver.quit()
        }

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