package involveMe.pages;

import java.util.Set;

import involveMe.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BaseDriverPage extends BaseDriver {

    protected JavascriptExecutor js;
    protected String mainWindow; //to move between windows

    public BaseDriverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    protected void sendKeys(WebElement elementToSendKeys, String key) {
        elementToSendKeys.sendKeys(key);
    }

    protected void fillText(WebElement el, String text) {
        highlightElement(el, "blue");
        el.clear();
        el.sendKeys(text);
    }

    protected void click(WebElement el) {
        highlightElement(el, "blue");
        el.click();
    }

    protected String getText(WebElement el) {
        highlightElement(el, "orange");
        return el.getText();
    }

    protected void alertOK(String name) {
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();
    }

    protected void alertOK() {
        driver.switchTo().alert().accept();
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void moveToNewWindow() {
        mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);

        Set<String> list = driver.getWindowHandles();
        for (String win : list) {
            driver.switchTo().window(win);
        }
        // run test on new window
    }

    protected void backToMainWindow() {
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    /*
     * Call this method with your element and a color like (red,green,orange etc...)
     */
    protected void highlightElement(WebElement element, String color) {
        //keep the old style to change it back
        String originalStyle = element.getAttribute("style");
        String newStyle = "background: yellow;border: 1px solid " + color + ";" + originalStyle;
        JavascriptExecutor js = (JavascriptExecutor) driver;

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
