package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/main/java/Features",
		glue= {"StepDefinition"},
		format= {"pretty","html:test-output"},
		monochrome=true,
		strict=true
		//dryRun=true
		)


public class TestRunner {
	
	
	

}
