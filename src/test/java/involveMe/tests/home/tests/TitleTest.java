package involveMe.tests.home.tests;

import involveMe.pages.home.HomePage;
import involveMe.tests.home.BaseHomeTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.constants.Strings;

public class TitleTest extends BaseHomeTest {
    private HomePage homePage;

    @Severity(SeverityLevel.NORMAL)
    @Description("checking page's title")
    @Test(priority = 6,
            description = "checking page's title")
    public void testTitle() {
        Assert.assertEquals(getTitle(), Strings.HomePageTitle);
    }
}
