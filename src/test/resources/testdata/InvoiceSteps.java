package stepdefinitions;
import org.openqa.selenium.Cookie;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.DriverFactory;

import java.time.Duration;

public class InvoiceSteps {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("user is on OpenCart login page")
    public void user_is_on_login_page() {
        driver.get("https://demo.opencart.com/TlbeVW/index.php?route=common/dashboard&user_token=8742fc3f3566fab5fae0907ee6d8090f");
    //     driver.manage().addCookie(
    // new Cookie("OCSESSID", "440f94a1423d9f5c9f9ee8979b"));
    // driver.navigate().refresh();
    }

    // @When("user enters username {string}")
    // public void user_enters_username(String username) {
    //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-username")))
    //         .sendKeys(username);
    // }

    // @When("user enters password {string}")
    // public void user_enters_password(String password) {
    //     driver.findElement(By.id("input-password")).sendKeys(password);
    // }

    // @When("user clicks on login button")
    // public void user_clicks_login() {
    //     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
    //     System.out.println("Current URL: " + driver.getCurrentUrl());
    // }
    
    @Then("user should see the dashboard")
    public void user_should_see_dashboard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @Then("user clicks orders in sales menu")
    public void user_clicks_orders_menu() {
        // Click Sales menu
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-sale"))).click();

        // Click Orders submenu
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Orders"))).click();
    }

    @Then("user enter orderid {string}")
    public void user_enter_order_id(String orderId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-order-id")))
            .sendKeys(orderId);
    }

    @Then("user clicks on filter button")
    public void user_clicks_filter() {
        driver.findElement(By.id("button-filter")).click();
    }

    @Then("user clicks action button")
    public void user_clicks_action_button() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[data-original-title='View']"))).click();
    }

    @Then("user clciks print invoice button")
    public void user_clicks_print_invoice() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[data-original-title='Print Invoice']"))).click();
    }
}