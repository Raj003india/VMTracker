package run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import method.method;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\USER\\IdeaProjects\\VMtracker\\src\\test\\java\\features\\VMoptions.feature"},
        plugin = {"pretty","html:target/cucumber-reports"}, glue ="stepdefinition",
        monochrome = true,
        tags="@Dashboard"
)
public class Runner {


}
