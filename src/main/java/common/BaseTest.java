package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected ResourceBundle resourceBundle = ResourceBundle.getBundle("env_dev");
    protected WebDriver driver;

    public WebDriver initializeDriver()
    {
        String browser = resourceBundle.getString("browser");

        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")){
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public void getScreenShotPath(String testcaseName, WebDriver driver) throws IOException {
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String destinationPath = System.getProperty("user.dir") + "/screenshots/" + testcaseName + timestamp + ".png";

        // take screenshot of the window to the temp folder
        File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

        // copy the screenshot file to the target
        FileUtils.copyFile(screenshotFile, new File(destinationPath));
    }
}
