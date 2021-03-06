package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
		features = "src\\main\\resources\\features\\Login.feature",
		glue = "steps",
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		dryRun = true
			)
public class RunnerTest {

}

