package involveMe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseDriver {

    protected WebDriver driver;

    @BeforeClass
    protected void setDriver(ITestContext testContext) {
        setupFirefoxDriver(testContext);
    }

    private void setupFirefoxDriver(ITestContext testContext) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        testContext.setAttribute("WebDriver", this.driver);
        driver.manage().window().maximize();
    }

    protected void holdPage() {
        driver.manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);
    }

    protected void goTo(String url) {
        driver.navigate().to(url);
    }

    protected String getTitle() {
        return driver.getTitle();
    }

    @AfterClass
    protected void quit() {
        driver.quit();
    }
}
