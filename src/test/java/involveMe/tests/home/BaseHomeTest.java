package involveMe.tests.home;

import involveMe.pages.home.HomePage;
import involveMe.tests.BaseDriverTest;
import org.testng.annotations.BeforeMethod;
import utilities.constants.URL;

public class BaseHomeTest extends BaseDriverTest {
    protected HomePage homePage;

    @BeforeMethod
    @Override
    protected void beforeTest() {
        goTo(URL.homePage);
        homePage = new HomePage(driver);
        holdPage();
    }
}
