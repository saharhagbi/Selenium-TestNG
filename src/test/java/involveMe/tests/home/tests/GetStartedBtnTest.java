package involveMe.tests.home.tests;

import involveMe.pages.home.HomePage;
import involveMe.tests.BaseDriverTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.constants.URL;
import utils.constants.Strings;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GetStartedBtnTest extends BaseDriverTest {
    private HomePage homePage;

    @BeforeMethod
    private void prepareTest() {
        homePage = new HomePage(driver);
        goTo(URL.homePage);
//        holdPage();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("checking if get started button is displayed with the correct string")
    @Test(priority = 2,
            description = "checking if get started button is displayedwith the correct string")
    public void isDisplayed() {
        boolean isCorrectText = homePage.getTextOfGetStartedBtn().equals(utils.constants.Strings.getStartedText);

        Assert.assertTrue((homePage.isGetStartedBtnDisplayed()) && (isCorrectText));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("checking if get started button is enabled")
    @Test(priority = 3)

    public void isEnabled() {
        Assert.assertTrue(homePage.isGetStartedBtnEnabled());
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("checking if click on get started button is moving to the correct page")
    @Test(priority = 4)
    public void onClickToCorrectPage() throws UnsupportedEncodingException {
        homePage.fillMailInGetStartedField(Strings.SaharMail);

        String mailDecoded = URLEncoder
                .encode(Strings.SaharMail, StandardCharsets.UTF_8.name());


        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.urlToBe(URL.getStartedOnClick + mailDecoded));

        Assert.assertTrue(isEmailDisplayedInForm());
    }

    private boolean isEmailDisplayedInForm() {
        //this input field is not the same like the one above, it is after getStarted clic
        return homePage.getAttributeEmailField("value").equals(Strings.SaharMail);
    }

}
