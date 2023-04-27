import base.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

public class MailTest  {
    protected static WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Page.setWebDriver(webDriver);
    }

    @Test
    public void sendingLetter() {
        MainPage mainPage = new MainPage();

        OwnPage page = mainPage.autorization(ConfigProperty.getProperty("userNameLoggin"), ConfigProperty.getProperty("userNamePassword"));
        page.sendEmail(ConfigProperty.getProperty("destination"), ConfigProperty.getProperty("email.subject"), ConfigProperty.getProperty("letter"));
    }

    @AfterClass
    public void tearDown() {
        webDriver.close();
    }
}