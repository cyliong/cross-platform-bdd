package com.example.ltp.list.step

import com.example.ltp.list.Context
import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import java.io.File

class Hooks(context: Context) : En {

    init {
        After { scenario: Scenario ->
            if (scenario.isFailed) {
                val file = (context.driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
                file.copyTo(File("screenshot.png"), true)
            }
            context.driver.quit()
        }
    }

}