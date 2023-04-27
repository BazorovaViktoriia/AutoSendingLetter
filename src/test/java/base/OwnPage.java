package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OwnPage extends Page {

    public OwnPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "div.application-mail__layout_main div.layout__column_left div.sidebar__header a") //кнопка перехода к написанию нового письма
    private WebElement writeEmailButton;

    @FindBy(xpath = "//div[@data-type='to']//input") //поле ввода адресата
    private WebElement toEmailInput;

    @FindBy(xpath = "//input[@name='Subject']")  //поле ввода темы письма
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@data-signature-id]/../..")  //поле ввода письма
    private WebElement emailBodyInput;

    @FindBy(xpath = "//button[@data-test-id='send']")  //кнопка отправки письма
    private WebElement sendBtn;



    public OwnPage sendEmail(String еmail, String subject, String body) {

        writeEmailButton.click();
        toEmailInput.sendKeys(еmail);
        subjectInput.sendKeys(subject);
        emailBodyInput.sendKeys(body);
        sendBtn.click();

        return new OwnPage();
    }
}
