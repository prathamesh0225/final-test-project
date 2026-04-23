package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;
public class Hooks {

    private static WebDriver driver;

    @Before
    public void setup() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}