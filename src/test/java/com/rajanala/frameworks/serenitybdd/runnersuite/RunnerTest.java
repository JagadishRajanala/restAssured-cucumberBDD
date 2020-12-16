package com.rajanala.frameworks.serenitybdd.runnersuite;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources",
        tags = {"@All"},
        plugin = {"pretty", "html:target/cucumber_reports"},
        glue = {"com.rajanala.frameworks.serenitybdd.stepDefinition"},
        monochrome = true,
        dryRun = false)

public class RunnerTest {
}
