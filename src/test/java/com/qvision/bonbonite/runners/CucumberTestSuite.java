package com.qvision.bonbonite.runners;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.glue", value = "com.qvision.bonbonite.stepdefinitions,net.serenitybdd.cucumber.actors")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty")
@ConfigurationParameter(key = "cucumber.filter.tags", value = "@smoke")
public class CucumberTestSuite {
}
