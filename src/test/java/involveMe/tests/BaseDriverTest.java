package involveMe.tests;

import involveMe.BaseDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseDriverTest extends BaseDriver {
    /*@BeforeMethod
    protected void beforeEachTest() {
        holdPage();
    }*/

    @AfterTest
    private void handleAfterTest() {
        quit();
    }
}
