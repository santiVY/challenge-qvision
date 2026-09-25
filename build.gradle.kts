plugins {
    java
    idea
    // 1. Plugin oficial para compilar el reporte visual "bonito" de Serenity
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

    systemProperty("cucumber.junit-platform.naming-strategy", "long")

    // 2. Hace que al terminar 'test', se ejecute automáticamente el reporte de Serenity
    finalizedBy("aggregate")
}

tasks.withType<Test> {
    systemProperty("serenity.project.name", "Bon-Bonite Automation")
}