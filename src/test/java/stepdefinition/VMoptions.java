package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import method.method;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class VMoptions {


    WebDriver driver;

    @Given("login")
    public void VM_login() {
        driver = new ChromeDriver();
        driver.get("https://tracker.vmmaps.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"login-tab\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("rajkumar200299@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Rajkumar@99");
        driver.findElement(By.xpath("//*[@id=\"loginSubmit\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[1]/p/p")));
    }

    @When("get all  {int} options in webpage")
    public void get_options(int expectCount) {
        List<WebElement> menuoptions = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[2]/a"));
        System.out.println(expectCount);
        Assert.assertEquals(expectCount, menuoptions.size());

    }

    @Then("validate options")
    public void validate_options(io.cucumber.datatable.DataTable dataTable) {
        List<String> option = dataTable.asList(String.class);
        List<WebElement> menuoptions = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[2]/a"));
        for (int i = 0; i < menuoptions.size(); i++) {
            Assert.assertEquals(option.get(i), menuoptions.get(i).getText());
        }
    }


    @When("click see more and inputs Engine {} and signal status {} and group filter")
    public void give_inputs(String opt, String opt1) {
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[4]/div/div[2]/div[1]/div[1]/p[2]")).click();
        String clr = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[1]/div/div[2]/a[2]")).getCssValue("color");
        String expectclr = "rgba(0, 0, 238, 1)";
        Assert.assertEquals(expectclr, clr);
        driver.findElement(By.xpath("//*[@id=\"dropDownSelect\"]/img")).click();
        List<WebElement> OPTIONS = driver.findElements(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div[4]/div/div[1]/div/div[2]/div[1]/div[2]/p"));
        for (WebElement ele : OPTIONS) {

            if (ele.getText().equals(opt)) {
                ele.click();
                break;
            }

        }
        driver.findElement(By.xpath("//*[@id=\"signalStatusDropdown\"]/img")).click();
        List<WebElement> Choice = driver.findElements(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div[4]/div/div[1]/div/div[2]/div[2]/div[2]/p"));
        for (WebElement ele1 : Choice) {
            if (ele1.getText().equals(opt1)) {
                ele1.click();
                break;
            }
        }

    }

    @Then("adjective map and take screenshot")
    public void ADJUST_map_and_take_screenprint() throws IOException, InterruptedException {
        for (int i = 0; i < 18;i++)
        {
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div[4]/div/div[2]/div[2]/div/div[2]/div[1]/div/a[2]")).click();

        }
        Thread.sleep(5000);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file , new File("C:\\Users\\USER\\IdeaProjects\\VMtracker\\src\\test\\screen\\img.png"));

    }
}

