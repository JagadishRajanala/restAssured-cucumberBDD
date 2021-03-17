package com.restAssured.frameworks.runnersuite;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/serviceFeatures/"},
        plugin = {"pretty", "html:target/cucumber_reports/index.html"},
        glue = {"com.restAssured.frameworks.stepDefinition"},
        monochrome = true,
        dryRun = false)

public class RunnerTest {
}
