plugins {
    java
    idea
}

group = "com.qvision.bonbonite"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Serenity BDD
    testImplementation("net.serenity-bdd:serenity-core:4.2.0")
    testImplementation("net.serenity-bdd:serenity-screenplay:4.2.0")
    testImplementation("net.serenity-bdd:serenity-screenplay-webdriver:4.2.0")
    testImplementation("net.serenity-bdd:serenity-cucumber:4.2.0")
    testImplementation("net.serenity-bdd:serenity-ensure:4.2.0")
    
    // Cucumber
    testImplementation("io.cucumber:cucumber-java:7.18.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.18.0")
    
    // JUnit 5
    testImplementation("org.junit.platform:junit-platform-suite:1.11.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0")
    
    // AssertJ
    testImplementation("org.assertj:assertj-core:3.26.0")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
}

// Serenity configuration
tasks.withType<Test> {
    systemProperty("serenity.project.name", "Bon-Bonite Automation")
    systemProperty("serenity.outputDirectory", "${project.buildDir}/serenity")
}