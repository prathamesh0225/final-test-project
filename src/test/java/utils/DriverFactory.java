package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {

    public static WebDriver getDriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
        // options.addArguments("user-data-dir=C:\\Users\\ASUS\\AppData\\Local\\Google\\Chrome\\User Data");
        // options.addArguments("profile-directory=Profile 2");

        options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");

            return new RemoteWebDriver(
                new URL("http://localhost:4444/"),
                options
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}