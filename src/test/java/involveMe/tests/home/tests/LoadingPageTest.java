package involveMe.tests.home.tests;

import involveMe.pages.home.HomePage;
import involveMe.tests.BaseDriverTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.constants.URL;


public class LoadingPageTest extends BaseDriverTest {
    private HomePage homePage;


    @BeforeMethod
    private void prepareTest() {
        homePage = new HomePage(driver);
        goTo(URL.homePage);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("checking if page loaded")
    @Test(priority = 5,
            description = "checking if page loaded")

    public void LoadingTest()  {

        new WebDriverWait(driver, utils.constants.Nums.PAGE_LOAD_TIMEOUT)
                .until(webDriver ->
                        homePage.ifPageIsLoaded());
    }
}
