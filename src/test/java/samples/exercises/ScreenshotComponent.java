package samples.exercises;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotComponent {
    public static void main(String[] arg) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

        // take screenshot of the window to the temp folder
        File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

        // copy the screenshot file to the target
        FileUtils.copyFile(screenshotFile, new File("/Users/ho.nguyen/Documents/selenium_screenshot.png"));

    }
}
