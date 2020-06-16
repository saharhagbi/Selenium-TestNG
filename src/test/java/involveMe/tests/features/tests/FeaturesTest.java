package involveMe.tests.features.tests;

import involveMe.tests.features.BaseFeaturesTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FeaturesTest extends BaseFeaturesTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("checking features button")
    @Test(priority = 1, description = "checking features button")
    public void testButton() throws InterruptedException {

        //Object borderColorFeaturesBtn = featuresPage.getBorderColorFeaturesBtn();
        String featuresBtnText = featuresPage.getFeaturesBtnText();

        //It is better to compare colors not by comparing strings hard coded because this way the test will be maintainability
        //Assert.assertEquals(borderColorFeaturesBtn, utils.constants.Strings.featuresBtnColor);
        Assert.assertEquals(featuresBtnText, utils.constants.Strings.featuesBtnText);

        Thread.sleep(5000);
    }

    @AfterTest
    private void handleAfterTest() {
        quit();
    }
}
