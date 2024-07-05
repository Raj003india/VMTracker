package run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\USER\\IdeaProjects\\VMtracker\\src\\test\\java\\features\\loginVM.feature"},
        plugin = {"pretty","html:target/cucumber-reports"}, glue ="stepdefinition",
        monochrome = true,
        tags="login"
)
public class Runner {

}
