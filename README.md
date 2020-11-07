# Cross-Platform BDD with Kotlin
This is an implementation of test automation for Android and iOS apps in
behavior-driven development (BDD) style, using Cucumber, Appium, Gradle, 
and Kotlin.

The sample scenario provided by the project is written to test the mobile apps 
built from the [list-android](https://github.com/cyliong/list-android) and 
[list-ios](https://github.com/cyliong/list-ios) projects. A screenshot will be 
taken if the test is failed.

Page Object pattern is used in the implementation to make the test code more 
readable, maintainable, and reusable. In addition, dependency injection is used to 
share state between steps.

## Building Blocks
- Kotlin/JVM
- Cucumber (Kotlin step definitions)
- Appium
- Gradle (Kotlin DSL)
- PicoContainer

## Setup
1. Place the app packages (e.g. list.apk and List.app built from 
[list-android](https://github.com/cyliong/list-android) and 
[list-ios](https://github.com/cyliong/list-ios)) to a directory.
2. Specify your paths to the app packages and set your desired capabilities 
in `DriverFactory.kt`.

## Running Android tests
1. Launch Android emulator.
2. Start Appium server.
3. Navigate to your project directory and run:
```
./gradlew testAndroid
```

## Running iOS tests
1. Launch iOS simulator.
2. Start Appium server.
3. Navigate to your project directory and run:
```
./gradlew testIOS
```