package samples.saucelabs;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
//        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
//        sauceOptions.setCapability("access_key", System.getenv("SAUCE_ACCESS_KEY"));
        sauceOptions.setCapability("username", "oauth-ho.nguyen-23180");
        sauceOptions.setCapability("access_key", "40132336-47e2-4ec2-8564-53cf9cd53868");
        sauceOptions.setCapability("name", "Check Amazon Home Page aaa");

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("sauce:options", sauceOptions);
        browserOptions.setCapability("platformName", "macOS 10.15");
        browserOptions.setCapability("browserVersion", "latest");


        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, browserOptions);
    }

    @Test (testName = "Home Page Test")
    public void homePageTest() {
        driver.get("https://www.amazon.com/");
        Assert.assertTrue(driver.getTitle().contains("Amazon.com"));
    }

    @Test
    public void searchProductTest() {
        driver.get("https://www.amazon.com/");
        Assert.assertTrue(driver.getTitle().contains("Amazon.com"));

        String searchText = "Macbook";
        WebElement txtSearch = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement btnSearch = driver.findElement(By.id("nav-search-submit-button"));

        // submit search
        txtSearch.click();
        txtSearch.sendKeys(searchText);
        btnSearch.click();

        // Check result
        WebElement spanResult = driver.findElement(By.cssSelector(".a-color-state"));
        Assert.assertTrue(spanResult.getText().contains(searchText));
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }

}
