package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features = {".//Features//AddOwner.feature"},
		features = {".//Features//FindOwnerDDT.feature"},
		glue = "stepDefinition",
		plugin= {"pretty", "html:reports/myreport.html", "json:reports/myreport.json", "rerun:target/rerun.txt"},
		dryRun=true,
		monochrome=true,
		tags="@sanity"  //Scenarios tagged with @sanity,
		)
public class TestRunner {

}
