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

public class AddNewPayeeScenarioOutline {

    WebDriver driver;

    @Given("User navigate to Bank app")
    public void user_navigate_to_bank_app() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");
    }
    @Given("User login to the bank account")
    public void user_login_to_the_bank_account() {
        WebElement loginInput = driver.findElement(By.cssSelector("input[name='user_login']"));
        loginInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='user_password']"));
        passwordInput.sendKeys("password");

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Sign in']"));
        submitButton.click();

        driver.navigate().back();
    }
    @Given("User click online banking on the homepage")
    public void user_click_online_banking_on_the_homepage() {
        WebElement onlineBankingButton = driver.findElement(By.id("onlineBankingMenu"));
        onlineBankingButton.click();
    }
    @When("User click on pay bills and click on add new payee")
    public void user_click_on_pay_bills_and_click_on_add_new_payee() {
        WebElement payBillsButton = driver.findElement(By.id("pay_bills_link"));
        payBillsButton.click();
        WebElement addNewPayee = driver.findElement(By.linkText("Add New Payee"));
        addNewPayee.click();

    }
    @Then("User should be able to fill out {string}, {string}, {string}, {string} and add new payee")
    public void user_should_be_able_to_fill_out_and_add_new_payee(String name, String address, String account, String details) {
        WebElement payeeNameInput = driver.findElement(By.cssSelector("input[name='name']"));
        payeeNameInput.sendKeys(name);

        WebElement payeeAddressInput = driver.findElement(By.cssSelector("div>textarea"));
        payeeAddressInput.sendKeys(address);

        WebElement payeeAccountInput = driver.findElement(By.cssSelector("input[name='account']"));
        payeeAccountInput.sendKeys(account);

        WebElement payeeDetails = driver.findElement(By.id("np_new_payee_details"));
        payeeDetails.sendKeys(details);

        WebElement addButton = driver.findElement(By.id("add_new_payee"));
        addButton.click();

    }
    @Then("User should see success message")
    public void user_should_see_success_message() {
        WebElement successMessage = driver.findElement(By.xpath("//div[text()='The new payee Sergio was successfully created.']"));
        Assert.assertTrue(successMessage.getText().toLowerCase().contains("sergio"));


    }

    @Then("User should see error message: Please fill out this field.")
    public void user_should_see_error_message_please_fill_out_this_field() {

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://zero.webappsecurity.com/bank/pay-bills.html";

        Assert.assertEquals(actualUrl, expectedUrl);

    }

}
