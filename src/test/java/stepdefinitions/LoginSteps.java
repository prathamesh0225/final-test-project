package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import hooks.Hooks;

public class LoginSteps {

    WebDriver driver = Hooks.getDriver();

    @Given("user is on the ParaBank login page {string}")
    public void user_is_on_login_page(String url) {
        driver.get(url);
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        driver.findElement(By.name("username")).clear();

        // Handle empty username from Examples table
        if (username != null && !username.trim().isEmpty()) {
            driver.findElement(By.name("username")).sendKeys(username);
        }
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        driver.findElement(By.name("password")).clear();

        // Handle empty password from Examples table
        if (password != null && !password.trim().isEmpty()) {
            driver.findElement(By.name("password")).sendKeys(password);
        }
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }

    @Then("login should be {string}")
public void login_should_be(String result) {

    String currentUrl = driver.getCurrentUrl();

    if (result.equalsIgnoreCase("success")) {
        Assert.assertTrue(currentUrl.contains("overview"));
    } else {
        String errorMsg = driver.findElement(By.cssSelector(".error")).getText();
        Assert.assertTrue(errorMsg.length() > 0);
    }
}
}