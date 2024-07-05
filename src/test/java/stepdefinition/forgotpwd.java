package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class forgotpwd {

    WebDriver driver;

    @Given("enter page and click forgotpwd")
    public void loginpage_VM() {
        driver = new ChromeDriver();
        driver.get("https://tracker.vmmaps.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/div[3]/div[2]")).click();
    }

    @When("click forgotpwd link and without emailid")
    public void valid_withoutemail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div")));
        //driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("rajkumar200299@gmail.com");
    }

    @Then("validate the Error")
    public void check_Error() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[2]/button[2]")).click();
        Thread.sleep(1000);
    }



    @When("click forgotpwd link and withinvalid emailid")
    public void valid_withinvaliademail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div")));
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Rajkunar$chrome.com");
    }

    @Then("Validate the Error Message")
    public void check_invalidemail_Error() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[2]/button[2]")).click();
        Thread.sleep(1000);
    }




    @When("click another window and get name of that window")
    public void valid_email() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div")));
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("rajkumar200299@gmail.com");


    }

    @Then("check the Email id details and close that particular window")
    public void check_result() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[2]/button[2]")).click();
        Thread.sleep(8000);
        String out = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div/div[2]/p")).getText();
        Assert.assertEquals(out,"Check your email account for reset link!");
    }


}
