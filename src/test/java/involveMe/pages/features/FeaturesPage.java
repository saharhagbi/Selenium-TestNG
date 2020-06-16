package involveMe.pages.features;


import involveMe.pages.BaseDriverPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.constants.Paths;

public class FeaturesPage extends BaseDriverPage {

    public FeaturesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = Paths.featuresBtnPath)
    private WebElement featuresBtn;

    public String getFeaturesBtnText() {
        return getText(featuresBtn);
    }

    @Step("return featured button border color")
    public Object getBorderColorFeaturesBtn() {
        return js
                .executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('border-bottom');", featuresBtn)
                .toString();
    }
}

