package involveMe.tests.features;

import involveMe.pages.features.FeaturesPage;
import involveMe.tests.BaseDriverTest;
import org.testng.annotations.BeforeMethod;
import utilities.constants.URL;

public class BaseFeaturesTest extends BaseDriverTest {

    protected FeaturesPage featuresPage;

    @BeforeMethod
    @Override
    protected void beforeTest() {
        goTo(URL.featuresPage);
        featuresPage = new FeaturesPage(driver);
        holdPage();
    }
}
