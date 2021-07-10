package com.bfyamada.monthlycontrol;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = "com.bfyamada.monthlycontrol.steps",
        plugin = {"json:target/cucumber.json", "pretty", "html:target/cucumber-reports/cucumber-pretty.html"},
        monochrome = true
)
public class TestRunner {
}
