package com.example.ltp.list.step

import com.example.ltp.list.Context
import io.cucumber.java8.En
import io.cucumber.java8.Scenario

class Hooks(context: Context) : En {

    init {
        After { _: Scenario ->
            context.driver.quit()
        }
    }

}