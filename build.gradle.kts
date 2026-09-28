plugins {
    java
    idea
    id("net.serenity-bdd.serenity-gradle-plugin") version "4.2.26"
}

group = "com.qvision.bonbonite"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val serenityVersion = "4.2.26"

dependencies {
    // Serenity BDD Core
    testImplementation("net.serenity-bdd:serenity-core:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-screenplay:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-screenplay-webdriver:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-cucumber:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-ensure:$serenityVersion")
    testImplementation("org.slf4j:slf4j-api:2.0.13")
    testImplementation("ch.qos.logback:logback-classic:1.5.6")

    // Cucumber + JUnit 5 Platform
    testImplementation("io.cucumber:cucumber-java:7.18.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.18.0")

    // JUnit 5
    testImplementation("org.junit.platform:junit-platform-suite:1.11.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0")

    // AssertJ
    testImplementation("org.assertj:assertj-core:3.26.3")
}

tasks.test {
    useJUnitPlatform()

    maxParallelForks = 1
    systemProperty("cucumber.execution.parallel.enabled", "false")
    systemProperty("cucumber.junit-platform.naming-strategy", "long")

    testLogging {
        showStandardStreams = true
    }

    finalizedBy("aggregate")
}

tasks.withType<Test> {
    systemProperty("serenity.project.name", "Bon-Bonite Automation")
}
