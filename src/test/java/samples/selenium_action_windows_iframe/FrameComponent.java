package samples.selenium_action_windows_iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FrameComponent {

    @Test
    public void frameTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        // Switch to iFrame
        WebElement iframeEl = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframeEl);
        //driver.switchTo().frame(0);

        WebElement dragEl = driver.findElement(By.id("draggable"));
        WebElement dropEl = driver.findElement(By.id("droppable"));

        // Do Drag & Drop action
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragEl, dropEl).build().perform();

        // Switch to default content
        driver.switchTo().defaultContent();
        WebElement desEl = driver.findElement(By.cssSelector(".desc"));
        System.out.println(desEl.getText());




    }
}
