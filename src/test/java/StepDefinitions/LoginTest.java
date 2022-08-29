package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    @Given("User navigate to website")
    public void user_navigate_to_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");

    }
    @When("User enter valid {string} and {string}")
    public void user_enter_valid_and(String username, String password) {
        WebElement loginInput = driver.findElement(By.cssSelector("input[name='user_login']"));
        loginInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='user_password']"));
        passwordInput.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Sign in']"));
        submitButton.click();

        driver.navigate().back();

    }
    @Then("User should login successfully")
    public void user_should_login_successfully() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://zero.webappsecurity.com/index.html";

        Assert.assertEquals(actualUrl,expectedUrl);

    }
    @When("User enter valid {string} and invalid {string}")
    public void user_enter_valid_and_invalid(String username2, String password2) {
        WebElement loginInput = driver.findElement(By.cssSelector("input[name='user_login']"));
        loginInput.sendKeys(username2);

        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='user_password']"));
        passwordInput.sendKeys(password2);

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Sign in']"));
        submitButton.click();



    }
    //
    @When("User enter invalid {string} and valid {string}")
    public void user_enter_invalid_and_valid(String username3, String password3) {
        WebElement loginInput = driver.findElement(By.cssSelector("input[name='user_login']"));
        loginInput.sendKeys(username3);

        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='user_password']"));
        passwordInput.sendKeys(password3);

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Sign in']"));
        submitButton.click();



    }

    @When("User enter invalid {string} and invalid {string}")
    public void user_enter_invalid_and_invalid(String username4, String password4) {
        WebElement loginInput = driver.findElement(By.cssSelector("input[name='user_login']"));
        loginInput.sendKeys(username4);

        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='user_password']"));
        passwordInput.sendKeys(password4);

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Sign in']"));
        submitButton.click();



    }
    @Then("Login should fail")
    public void login_should_fail() {
        WebElement errorMessage = driver.findElement(By.cssSelector("#login_form>div"));
        String actualError = errorMessage.getText().toLowerCase();
        String msg = "Login and/or password are wrong.";
        String expectedResult = msg.toLowerCase();
        Assert.assertEquals(actualError,expectedResult);

        driver.quit();
    }

}
