package involveMe.tests.home;

import involveMe.pages.home.HomePage;
import involveMe.tests.BaseDriverTest;
import org.testng.annotations.BeforeTest;
import utilities.constants.URL;

public class BaseHomeTest extends BaseDriverTest {
    protected HomePage homePage;

    @BeforeTest
    private void prepareTest() {
        homePage = new HomePage(driver);
        goTo(URL.homePage);
//        holdPage();
    }
}
