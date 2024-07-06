package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login {
    WebDriver driver;

    @Given("enter page and click login")
    public void VMtracker_loginpage() {
        driver = new ChromeDriver();
        driver.get("https://tracker.vmmaps.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"login-tab\"]")).click();
    }

    @When("enter valid username and password")
    public void user_login_with_username_and_correct_password(){
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("rajkumar200299@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Rajkumar@99");

    }


    @Then("click login and check message")
    public void click_login_and_check_message() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"loginSubmit\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement txt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[1]/p/p")));
        String name= txt.getText();
        Assert.assertEquals(name,"Rajkumar");
    }

    @When("enter valid username and without password")
    public void user_login_with_username_and_incorrect_password() {
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Rajkumar200299@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("");
    }


    @Then("click login and check pwd Error message")
    public void Enter_password() {
        driver.findElement(By.xpath("//*[@id=\"loginSubmit\"]")).click();
        //add wait untill
       String  Error =driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/h3")).getText();
       Assert.assertEquals(Error,"Please Enter Password");

    }

    @When("ignore username and password")
    public void user_login_without_username_and_password() {
        driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
    }

    @Then("click login and check username and pwd Error message")
    public void Enter_username_password() {
        driver.findElement(By.xpath("//*[@id=\"loginSubmit\"]")).click();
        String  Erroruser =driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/h3[1]")).getText();
        String  Errorpwd =driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/h3[2]")).getText();
        Assert.assertEquals(Erroruser,"Please Enter Valid Email");
        Assert.assertEquals(Errorpwd,"Please Enter Password");


    }

     @When("ENTER username and password")
    public void user_login_username_and_password() {
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Rajkumar200299@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Rajkumar@99");
    }

    @Then("click login")
    public void username_password() {
        driver.findElement(By.xpath("//*[@id=\"loginSubmit\"]")).click();

    }

}
