package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.N;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class register {

    WebDriver driver;

//invalid password

    @Given("enter page and check login")
    public void loginpage_VM() {
        driver = new ChromeDriver();
        driver.get("https://tracker.vmmaps.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"register-tab\"]")).click();
    }

    @When("Enter only invalid password")
    public void Enter_invalid_pwd() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]")));
        driver.findElement(By.xpath("//*[@id=\"Name\"]")).sendKeys("Rajkumar");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Rajkumar200299@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/div[3]/input")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("R3655355557776666");
        driver.findElement(By.xpath("//*[@id=\"registerSubmit\"]")).click();

    }

    @Then("validate Error message for password")
    public void check_pwdError() throws InterruptedException {
        String ERRmsg = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/h3")).getText();
        Thread.sleep(1000);
        Assert.assertEquals(ERRmsg, "Password must contain a small case capital case a number and a symbol");
    }

    //Invalid Email

    @When("Enter only invalid Email")
    public void invalid_email() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]")));
        driver.findElement(By.xpath("//*[@id=\"Name\"]")).sendKeys("Rajkumar");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Rajkumar200299");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/div[3]/input")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Rajkumar@13");
        driver.findElement(By.xpath("//*[@id=\"registerSubmit\"]")).click();
    }

    @Then("validate Error message for Email")
    public void check_emailError() throws InterruptedException {
        String ERRmsg = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/h3[1]")).getText();
        Thread.sleep(1000);
        Assert.assertEquals(ERRmsg, "Please Enter Valid Email");

    }

    //invalid phonenumber

    @When("Enter only invalid phonenumber")
    public void invalid_phonenum() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]")));
        driver.findElement(By.xpath("//*[@id=\"Name\"]")).sendKeys("jfhku4gr43ar");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("jk976e9@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/div[3]/input")).sendKeys("542537");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Rajkumahhr@13");
        driver.findElement(By.xpath("//*[@id=\"registerSubmit\"]")).click();
    }

    @Then("validate Error message for phonenumber")
    public void check_Error_phone() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement WE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div")));
        String msg = WE.getText();
        Assert.assertEquals(msg, "Succuessfully Registered");

    }

    //existing details

    @When("Enter existing  details validate error msg")
    public void give_valid_existingdetails() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]")));
        driver.findElement(By.xpath("//*[@id=\"Name\"]")).sendKeys("Rajkumar");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Rajkumar200299@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/div[3]/input")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Rajkumar@99");
        driver.findElement(By.xpath("//*[@id=\"registerSubmit\"]")).click();

    }

    @Then("Validate_error")
    public void validate_messsage()
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement WE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div/div[1]/div[2]")));
            String msg = WE.getText();
            Assert.assertEquals(msg, "User mobile or email already exists");

        }


//choose country
    @When("Enter valid details and choose Russia country")
    public void give_valid_details_choose_Russia() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]")));
        driver.findElement(By.xpath("//*[@id=\"Name\"]")).sendKeys("Rajkuma865r");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Rajkumar200299@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/div[3]/input")).sendKeys("123456786860");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Rajkumar@99");
        Thread.sleep(2000);
        List<WebElement> COUNTRY = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/div[3]/div/select/option"));
        for (WebElement NAME :COUNTRY){
            if(NAME.getText().equals("Russia")){
                NAME.click();
                System.out.println(NAME.getText());
            }
        }
        driver.findElement(By.xpath("//*[@id=\"registerSubmit\"]")).click();

    }

    @Then("register the details successfully")
    public void validate_successful_registration() {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement WE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div/div[1]/div[2]")));
            String msg = WE.getText();
            Assert.assertEquals(msg, "User mobile or email already exists");
    }


}
