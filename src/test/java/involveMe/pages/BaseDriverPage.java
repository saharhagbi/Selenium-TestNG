package involveMe.pages;

import involveMe.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BaseDriverPage extends BaseDriver {

    protected JavascriptExecutor js;

    public BaseDriverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    protected void sendKeys(WebElement elementToSendKeys, String key) {
        elementToSendKeys.sendKeys(key);
    }

    protected void click(WebElement elementToClickOn) {
        highlightElement(elementToClickOn, "blue");
        elementToClickOn.click();
    }

    protected String getText(WebElement elementToGetTextFrom) {
        highlightElement(elementToGetTextFrom, "orange");
        return elementToGetTextFrom.getText();
    }


    protected void highlightElement(WebElement element, String color) {
        //keep the old style to change it back
        String originalStyle = element.getAttribute("style");
        String newStyle = "background: yellow;border: 1px solid " + color + ";" + originalStyle;

        // Change the style
        js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
                element);

        // Change the style back after few miliseconds
        js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
                + originalStyle + "');},400);", element);
    }

    protected boolean ifPageIsLoaded() {
        return js
                .executeScript("return document.readyState")
                .equals("complete");
    }

    protected boolean isDisplayed(WebElement elementToCheck) {
        return elementToCheck.isDisplayed();
    }

    protected boolean isEnabled(WebElement elementToCheck) {
        return elementToCheck.isEnabled();
    }

    protected String getAttribute(WebElement elementToCheck, String attribute) {
        return elementToCheck.getAttribute(attribute);
    }
}
