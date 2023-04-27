package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {

    public MainPage() {
        webDriver.get(ConfigProperty.getProperty("url"));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//button[@data-testid='enter-mail-primary']") //кнопка перехода на страницу ввода логина
    private WebElement btnLoggin;

    private final By loginFormIframe = By.cssSelector("iframe.ag-popup__frame__layout__iframe");
    private final By loginForm = By.xpath("//div[@data-test-id='login-app-ready']");

    @FindBy(xpath = "//input[@name='username']")   //поле ввода логина
    private WebElement inputUserName;

    @FindBy(xpath = "//button[@data-test-id='next-button']") //кнопка перехода на страницу ввода пароля
    private WebElement btnPassword;

    @FindBy(xpath = "//input[@name='password']") //поле ввода пароля
    private WebElement inputPassword;

    @FindBy(xpath = "//div[@data-test-id='login-app-ready']//button[@data-test-id='submit-button']") //кнопка перехода на главную страницу почты
    private WebElement btnMail;


    public OwnPage autorization(String username, String password) {
        this.btnLoggin.click();

        WebElement iframe = webDriver.findElement(loginFormIframe);
        webDriver.switchTo().frame(iframe);

        this.inputUserName.sendKeys(username);
        this.btnPassword.click();
        this.inputPassword.sendKeys(password);
        this.btnMail.click();
        webDriver.switchTo().defaultContent();

        return new OwnPage();
    }
}