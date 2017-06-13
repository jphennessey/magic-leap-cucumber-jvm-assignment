package step_definitions;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import java.io.File;
import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
		tags = {}
		)
public class RunCukesTest {

	@AfterClass
	public static void teardown() throws IOException {
		File configFile = new File("src/test/resources/extent-config.xml");
		Reporter.loadXMLConfig(configFile);
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Mac OSX");
		Reporter.setTestRunnerOutput("Teardown is now running...");
	}
}