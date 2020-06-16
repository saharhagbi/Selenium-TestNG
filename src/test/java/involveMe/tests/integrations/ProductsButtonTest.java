package involveMe.tests.integrations;

import involveMe.pages.intergrations.IntegrationsPage;
import involveMe.tests.BaseDriverTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.constants.URL;

public class ProductsButtonTest extends BaseDriverTest {

    private IntegrationsPage integrationsPage;

    @BeforeMethod
    public void preparePage() {
        integrationsPage = new IntegrationsPage(driver);
        goTo(URL.homePage);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("checking first item in product's drop down menu is moving to the correct page")
    @Test(priority = 7)
    private void testDropDownMenu() {
        integrationsPage.openDropDownProducts();
        integrationsPage.acceptPayOnlineBtnOnClick();

        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.urlToBe(URL.paymentURL));
    }
}
