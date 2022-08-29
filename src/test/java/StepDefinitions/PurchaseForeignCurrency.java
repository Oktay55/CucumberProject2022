package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class PurchaseForeignCurrency {
    WebDriver driver;

    @Given("User navigate to Zero Bank app")
    public void user_navigate_to_zero_bank_app() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");
    }
    @And("User login to the account")
    public void user_login_to_the_account() {
        WebElement loginInput = driver.findElement(By.cssSelector("input[name='user_login']"));
        loginInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='user_password']"));
        passwordInput.sendKeys("password");

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Sign in']"));
        submitButton.click();

        driver.navigate().back();

    }
    @Given("User go click online banking on the homepage")
    public void user_go_click_online_banking_on_the_homepage() {
        WebElement onlineBankingButton = driver.findElement(By.id("onlineBankingMenu"));
        onlineBankingButton.click();

    }
    @When("User click on pay bills and click on purchase foreign currency")
    public void user_click_on_pay_bills_and_click_on_purchase_foreign_currency() {
        WebElement payBillsButton = driver.findElement(By.id("pay_bills_link"));
        payBillsButton.click();
        WebElement purchaseCurrencyButton = driver.findElement(By.linkText("Purchase Foreign Currency"));
        purchaseCurrencyButton.click();


    }
    @Then("User should select the {string} they want, {string}, and select \\(USD) radio button")
    public void user_should_select_the_they_want_and_select_usd_radio_button(String currency, String amount) {
        WebElement currencyDropdown = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDropdown);
        select.selectByVisibleText(currency);

        WebElement amountInput = driver.findElement(By.id("pc_amount"));
        amountInput.sendKeys(amount);

        WebElement usDollarRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        usDollarRadioButton.click();

        WebElement purchaseButton = driver.findElement(By.id("purchase_cash"));
        purchaseButton.click();


    }
    @And("User should be able to see success message after clicking on the purchase button")
    public void user_should_be_able_to_see_success_message_after_clicking_on_the_purchase_button() {

        WebElement successMessage = driver.findElement(By.xpath("//div[text()='Foreign currency cash was successfully purchased.']"));
        Assert.assertTrue(successMessage.getText().toLowerCase().contains("foreign"));

    }

}
