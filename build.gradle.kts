plugins {
    kotlin("jvm") version "1.6.10"
}

val cucumberVersion = "7.2.2"
val appiumVersion = "8.0.0"
val seleniumVersion = "4.1.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.cucumber:cucumber-java8:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-junit:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-picocontainer:$cucumberVersion")
    testImplementation("io.appium:java-client:$appiumVersion")
    testImplementation("org.seleniumhq.selenium:selenium-java:$seleniumVersion")
}

val cucumberRuntime: Configuration by configurations.creating {
    extendsFrom(configurations.testImplementation.get())
}

arrayOf("Android", "IOS").forEach { platform ->
    tasks.register<JavaExec>("test$platform") {
        mainClass.set("io.cucumber.core.cli.Main")
        classpath = cucumberRuntime + sourceSets.main.get().output + sourceSets.test.get().output
        args = listOf("--plugin", "pretty", "--glue", "com.example.ltp.list", "src/test/resources")
        systemProperty("platform", platform.toLowerCase())
    }
}