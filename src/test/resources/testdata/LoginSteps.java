package stepdefinitions;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utils.DriverFactory;
import java.lang.Thread;
import org.testng.Assert;
public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on DemoQA login page")
    public void openLoginPage() {
        driver = DriverFactory.getDriver(); // Selenium Grid
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @When("user enters username {string}")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("user enters password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks on login button")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("user should see the dashboard")
    public void verifyDashboard() throws InterruptedException {
        Thread.sleep(5000);
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("profile"));
    }
}