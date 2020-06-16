package involveMe.pages.home;

import involveMe.pages.BaseDriverPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseDriverPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email-filled-button-001")
    private WebElement getStartedBtn;
    @FindBy(name = "email")
    private WebElement emailInputField;


    public String getTextOfGetStartedBtn() {
        return getText(getStartedBtn);
    }

    public boolean isGetStartedBtnDisplayed() {
        return isDisplayed(getStartedBtn);
    }

    public boolean isGetStartedBtnEnabled() {
        return isEnabled(getStartedBtn);
    }

    @Step("fill sahar email and click on get started button")
    public void fillMailInGetStartedField(String key) {
        sendKeys(emailInputField, key);
        click(getStartedBtn);
    }

    public String getAttributeEmailField(String attribute) {
        return getAttribute(emailInputField, attribute);
    }

    public boolean ifPageIsLoaded() {
        return super.ifPageIsLoaded();
    }

}
