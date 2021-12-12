package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true,
		features = "src\\test\\resources\\features\\DemoBlazeFeature.feature",
		glue = {"stepdefs"},
		monochrome = true,
//		dryRun=true,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:test-output/SparkReport/ExtentReport.html",
				"html:target/reports/MainHTMLReport.html"
				,"pretty"
				}
		)
public class DemoBlazeRunner {

}
