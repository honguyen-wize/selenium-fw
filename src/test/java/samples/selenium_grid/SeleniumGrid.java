package samples.selenium_grid;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {
    @Test
    public void seleniumGridTest() throws MalformedURLException {
        DesiredCapabilities ds = new DesiredCapabilities();
        ds.setPlatform(Platform.MAC);

        ds.setBrowserName("chrome");
//      ds.setBrowserName("safari"); // no need to have safari driver, just enable "allow remote" in safari's Node machine

//        ds.setBrowserName("firefox");
//        ds.setCapability("marionette", true);

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.247:4444/wd/hub"), ds);
        driver.get("https://www.amazon.com/");

        System.out.println(driver.getTitle());

        driver.quit();

        // kill -9 $(lsof -ti tcp:4444)
    }
}
