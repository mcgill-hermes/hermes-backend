package ecse428.hermes.features.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin ="pretty",
		features = "src/test/resources/features",
		glue= "stepDefinition")

public class CucumberTestRunner {
}
