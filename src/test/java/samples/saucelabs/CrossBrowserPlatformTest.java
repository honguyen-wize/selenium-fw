package samples.saucelabs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Tests whoing how to run cross browser tests with TestNG Sauce Bindings jar when Parameterized.
 */
public class CrossBrowserPlatformTest {
    protected RemoteWebDriver driver;

    @RegisterExtension
    public SauceTestWatcher watcher = new SauceTestWatcher();

    @DataProvider
    public static Object[][] sauceBrowserDataProvider() {
        Object[][] data = new Object[2][3];

        data[0][0] = "firefox";
        data[0][1] = "latest";
        data[0][2] = "macOS 11.00";

        data[1][0] = "chrome";
        data[1][1] = "latest";
        data[1][2] = "Windows 10";

        return data;
    }


    private void setup(String browserName, String browserVersion, String platformName) throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-ho.nguyen-23180");
        sauceOptions.setCapability("access_key", "40132336-47e2-4ec2-8564-53cf9cd53868");
        sauceOptions.setCapability("name", "Cross Browser AAA");
        sauceOptions.setCapability("browserVersion", browserVersion);
        sauceOptions.setCapability("platformName", platformName);

        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        chromeOptions.setCapability("sauce:options", sauceOptions);
        firefoxOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, browserName.equalsIgnoreCase("chrome") ? chromeOptions : firefoxOptions);
    }

    @DisplayName("Check Login Page")
    @Test(dataProvider = "sauceBrowserDataProvider")
    public void checkLoginPage(String browser, String browserVersion, String platformName) throws MalformedURLException {

        System.out.println(browser + browserVersion + platformName);
        setup(browser, browserVersion, platformName);
        driver.get("https://www.saucedemo.com");
        Assert.assertEquals("Swag Labs", driver.getTitle());
    }

    @DisplayName("Do Login Check")
    @Test(dataProvider = "sauceBrowserDataProvider")
    public void doLoginCheck(String browser, String browserVersion, String platformName) throws MalformedURLException {
        setup(browser, browserVersion, platformName);

        driver.get("https://www.saucedemo.com");

        By usernameFieldLocator = By.id("user-name");
        By passwordFieldLocator = By.id("password");
        By submitButtonLocator = By.id("login-button");
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
