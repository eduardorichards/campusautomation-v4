package com.eduardorichards.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.eduardorichards.steps", "com.eduardorichards.hooks"},
    plugin = {"pretty", "html:target/cucumber-reports/report.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
    }
