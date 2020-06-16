package involveMe.pages.intergrations;

import involveMe.pages.BaseDriverPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.constants.Paths;

public class IntegrationsPage extends BaseDriverPage {
    public IntegrationsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = Paths.productsBtn)
    private WebElement productsBtn;
    @FindBy(xpath = Paths.acceptPayOnlineBtn)
    private WebElement acceptPayOnlineBtn;

    @Step("move cursor to 'products' button at nav bar in order to see drop down menu")
    public void openDropDownProducts() {
        Actions seriesOfActions = new Actions(driver);
        seriesOfActions
                .moveToElement(productsBtn)
                .moveToElement(acceptPayOnlineBtn)
                .build()
                .perform();
    }

    public void acceptPayOnlineBtnOnClick() {
        click(acceptPayOnlineBtn);
    }
}
