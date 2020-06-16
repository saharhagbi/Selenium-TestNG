package involveMe.tests;

import involveMe.BaseDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public abstract class BaseDriverTest extends BaseDriver {
    @BeforeMethod
    protected abstract void beforeTest();

    @AfterTest
    private void handleAfterTest() {
        quit();
    }
}
