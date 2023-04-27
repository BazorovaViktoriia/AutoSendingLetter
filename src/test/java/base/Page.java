package base;

import org.openqa.selenium.WebDriver;

public class Page {
    protected static WebDriver webDriver;

    public static void setWebDriver(WebDriver driver) {

        webDriver = driver;
    }
}