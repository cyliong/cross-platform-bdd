plugins {
    kotlin("jvm") version "1.4.31"
}

val cucumberVersion = "6.10.1"
val appiumVersion = "7.5.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.cucumber:cucumber-java8:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-junit:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-picocontainer:$cucumberVersion")
    testImplementation("io.appium:java-client:$appiumVersion")
}

val cucumberRuntime: Configuration by configurations.creating {
    extendsFrom(configurations.testImplementation.get())
}

arrayOf("Android", "IOS").forEach { platform ->
    tasks.register<JavaExec>("test$platform") {
        main = "io.cucumber.core.cli.Main"
        classpath = cucumberRuntime + sourceSets.main.get().output + sourceSets.test.get().output
        args = listOf("--plugin", "pretty", "--glue", "com.example.ltp.list", "src/test/resources")
        systemProperty("platform", platform.toLowerCase())
    }
}