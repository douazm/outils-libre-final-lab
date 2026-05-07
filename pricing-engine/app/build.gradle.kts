plugins {
    java // أضيفي هذا السطر ليتمكن gradle من فهم لغة جافا
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // مكتبة الاختبارات JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// هذا الجزء يخبر البرنامج أي إصدار جافا يستخدم
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25) 
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}