package involveMe.tests.integrations;

import involveMe.pages.intergrations.IntegrationsPage;
import involveMe.tests.BaseDriverTest;
import org.testng.annotations.BeforeMethod;
import utilities.constants.URL;

public class BaseIntegrationsTest extends BaseDriverTest {

    private IntegrationsPage integrationsPage;

    @BeforeMethod
    @Override
    protected void beforeTest() {
        goTo(URL.integrationsURL);
        integrationsPage = new IntegrationsPage(driver);
        holdPage();
    }
}
