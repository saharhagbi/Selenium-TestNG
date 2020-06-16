package involveMe.tests.home.tests;

import involveMe.tests.home.BaseHomeTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.constants.Nums;


public class LoadingPageTest extends BaseHomeTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("checking if page loaded")
    @Test(priority = 5,
            description = "checking if page loaded")

    public void LoadingTest() {
        new WebDriverWait(driver, Nums.PAGE_LOAD_TIMEOUT)
                .until(webDriver ->
                        homePage.ifPageIsLoaded());
    }
}
