package samples.saucelabs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Login tests with Selenium.
 */
public class SeleniumLogin_UploadResult {
    protected RemoteWebDriver driver;

    @RegisterExtension
    public SauceTestWatcher watcher = new SauceTestWatcher();

    @BeforeEach
    public void setup(TestInfo testInfo) throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
//        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
//        sauceOptions.setCapability("access_key", System.getenv("SAUCE_ACCESS_KEY"));
        sauceOptions.setCapability("username", "oauth-ho.nguyen-23180");
        sauceOptions.setCapability("access_key", "40132336-47e2-4ec2-8564-53cf9cd53868");
        sauceOptions.setCapability("name", testInfo.getDisplayName());
        sauceOptions.setCapability("browserVersion", "latest");

        ChromeOptions options = new ChromeOptions();
        options.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, options);
    }

    @DisplayName("Swag Labs Login Page Check 000")
    @Test
    public void swagLabsLoginCheckPage() {
        driver.get("https://www.saucedemo.com");
        Assertions.assertTrue(driver.getTitle().contains("Swag Labs"));
    }

    @DisplayName("Swag Labs Login Test 000")
    @Test
    public void swagLabsLoginTest() {
        driver.get("https://www.saucedemo.com");

        By usernameFieldLocator = By.id("user-name");
        By passwordFieldLocator = By.id("password");
        By submitButtonLocator = By.id("login-button");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until((driver) -> driver.findElement(usernameFieldLocator).isDisplayed());

        WebElement userNameField = driver.findElement(usernameFieldLocator);
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        WebElement submitButton = driver.findElement(submitButtonLocator);

        userNameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        submitButton.click();

        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    /**
     * Custom TestWatcher for Sauce Labs projects.
     */
    public class SauceTestWatcher implements TestWatcher {
        @Override
        public void testSuccessful(ExtensionContext context) {
            driver.executeScript("sauce:job-result=passed"); // to upload the test result
            driver.quit();
        }

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            driver.executeScript("sauce:job-result=failed");  // to upload the test result
            driver.quit();
        }
    }
}