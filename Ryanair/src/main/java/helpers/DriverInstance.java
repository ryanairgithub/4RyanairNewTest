package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInstance {

    private static WebDriver driver;

    public static WebDriver getInstance() {
        return driver;
    }

    public static void initialiseDriver() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        getInstance().navigate().to(Constans.URL);
    }

    public static void closeBrowserAndDriver() {
        getInstance().close();
        getInstance().quit();
    }
}
