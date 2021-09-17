package samples.exercises;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorComponent {
    public static void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // create javascriptExecutor to execute javascript script
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // scroll the window down
        js.executeScript("window.scrollBy(0,500)");

        // scroll the table down
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
    }
}
